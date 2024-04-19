package github.hua0512.ncm.apis.base

import github.hua0512.ncm.apis.CookiesProvider
import github.hua0512.ncm.apis.base.NeteaseHeaders.MUSIC_A
import github.hua0512.ncm.apis.base.NeteaseHeaders.MUSIC_U
import github.hua0512.ncm.apis.base.NeteaseHeaders.NMTID
import github.hua0512.ncm.apis.base.NeteaseHeaders.NUID
import github.hua0512.ncm.apis.base.NeteaseHeaders.REMEMBER_ME
import github.hua0512.ncm.apis.base.NeteaseHeaders.X_REAL_IP
import github.hua0512.ncm.apis.base.NeteaseSubHeaders.APP_VER
import github.hua0512.ncm.apis.base.NeteaseSubHeaders.APP_VER_STRING
import github.hua0512.ncm.apis.base.NeteaseSubHeaders.CSRF_TOKEN
import github.hua0512.ncm.apis.base.NeteaseSubHeaders.IOS
import github.hua0512.ncm.apis.base.NeteaseSubHeaders.OS
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.RequestMode
import github.hua0512.ncm.data.UserAgent
import github.hua0512.ncm.utils.eapiEncrypt
import github.hua0512.ncm.utils.generateRandomHex
import github.hua0512.ncm.utils.neteaseResponse
import github.hua0512.ncm.utils.weapiEncrypt
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

abstract class BaseNeteaseNetworkImpl(open val client: HttpClient) {

  companion object {
    const val BASE_URL = "https://music.163.com"
    const val INTERFACE_BASE_URL = "https://interface3.music.163.com"
    const val REAL_IP = "211.161.244.70"

  }


  val baseUrl: String = BASE_URL

  suspend inline fun <reified T, reified U> getApi(
    baseUrl: String = this.baseUrl,
    pathName: String = "",
    userAgent: UserAgent = UserAgent.PC,
    mode: RequestMode = RequestMode.WEAPI,
    block: HttpRequestBuilder.() -> Unit = {},
  ) = neteaseResponse<T, U> {
    val fullPath = computeFullPath(baseUrl, pathName, mode)
    client.prepareGet(fullPath) {
      block()
      setNeteaseRequest(mode, userAgent, fullPath, baseUrl, pathName)
    }.execute()
  }

  suspend inline fun <reified T, reified U> postApi(
    baseUrl: String = this.baseUrl,
    pathName: String = "",
    userAgent: UserAgent = UserAgent.PC,
    mode: RequestMode = RequestMode.WEAPI,
    block: HttpRequestBuilder.() -> Unit = {},
  ) = neteaseResponse<T, U> {
    val fullPath = computeFullPath(baseUrl, pathName, mode)
    client.preparePost(fullPath) {
      headers {
        append("Content-Type", "application/x-www-form-urlencoded")
      }
      block()
      setNeteaseRequest(mode, userAgent, fullPath, baseUrl, pathName)
    }.execute()
  }

  suspend inline fun <reified T, reified U> putApi(
    baseUrl: String = this.baseUrl,
    pathName: String = "",
    userAgent: UserAgent = UserAgent.PC,
    mode: RequestMode = RequestMode.WEAPI,
    block: HttpRequestBuilder.() -> Unit = {},
  ) = neteaseResponse<T, U> {
    val fullPath = computeFullPath(baseUrl, pathName)
    client.preparePut(fullPath) {
      block()
      setNeteaseRequest(mode, userAgent, fullPath, baseUrl, pathName)
    }.execute()
  }

  suspend inline fun <reified T> deleteApi(
    baseUrl: String = this.baseUrl,
    pathName: String = "",
    userAgent: UserAgent = UserAgent.PC,
    mode: RequestMode = RequestMode.WEAPI,
    block: HttpRequestBuilder.() -> Unit = {},
  ) = neteaseResponse<T, Unit> {
    val fullPath = computeFullPath(baseUrl, pathName)
    client.prepareDelete(fullPath) {
      block()
      setNeteaseRequest(mode, userAgent, fullPath, baseUrl, pathName)
    }.execute()
  }

  fun computeFullPath(baseUrl: String, pathName: String, mode: RequestMode = RequestMode.WEAPI): String {
    return (baseUrl + pathName).run {
      when (mode) {
        RequestMode.WEAPI -> {
          // replace starting /api with /weapi
          replaceFirst("/api", "/weapi")
        }

        RequestMode.EAPI -> {
          // replace starting /api with /eapi
          replaceFirst("/api", "/eapi")
        }

        else -> this
      }
    }
  }

  suspend fun HttpRequestBuilder.setNeteaseRequest(mode: RequestMode, userAgent: UserAgent, fullPath: String, baseUrl: String, pathName: String) {
    headers {
      append(HttpHeaders.UserAgent, userAgent.userAgent)
      // Referer is required for some requests
      if (baseUrl == BASE_URL) {
        append(HttpHeaders.Referrer, BASE_URL)
      }
      // add real ip
      append(X_REAL_IP, REAL_IP)
      append(HttpHeaders.XForwardedFor, REAL_IP)
    }

    CookiesProvider.addIfNotExists(NUID, generateRandomHex(16))
    if (fullPath.indexOf("login") == -1) {
      CookiesProvider.addIfNotExists(NMTID, generateRandomHex(16))
    }

    if (CookiesProvider.getCookie(MUSIC_U) == null) {
      // guest mode
      if (CookiesProvider.getCookie(MUSIC_A) == null) {
        // TODO: IMPLEMENT GUEST MODE
//                CookiesProvider.addCookie("MUSIC_A", generateRandomHex(16))
        CookiesProvider.addIfNotExists(OS, IOS)
        CookiesProvider.addIfNotExists(APP_VER, APP_VER_STRING)
      }
    } else {
      CookiesProvider.addIfNotExists(REMEMBER_ME, "true")
    }
    when (mode) {
      RequestMode.WEAPI -> {
        val jsonObject = buildJsonObject {
          this@setNeteaseRequest.url.parameters.build().toMap().forEach { (key, value) ->
            put(key, value.joinToString(","))
          }
          put(CSRF_TOKEN, CookiesProvider.getCookie(CSRF_TOKEN) ?: "")
        }
        val encText = weapiEncrypt(jsonObject)
        this.url.parameters.clear()
        this.url.parameters.append("params", encText["params"]!!)
        this.url.parameters.append("encSecKey", encText["encSecKey"]!!)
      }

      RequestMode.EAPI -> {
        val parameters = this.url.parameters.build().toMap().mapValues { (_, value) ->
          value.joinToString(",")
        }

        val data = buildJsonObject {
          parameters.forEach { (key, value) ->
            put(key, value)
          }
          val header = buildJsonObject {
            NeteaseSubHeaders.getHeaders(CookiesProvider).forEach { (key, value) ->
              put(key, value)
            }
          }
          put("header", header)
        }
        val encrypted = eapiEncrypt(pathName, data)
        this.url.parameters.clear()
        this.url.parameters.append("params", encrypted)
      }

      RequestMode.API -> {
        // do nothing
      }
    }
    header(HttpHeaders.Cookie, CookiesProvider.cookies)
  }

  suspend inline fun <reified T> NetworkResponse<JsonElement, FailedResponse>.transform(onSuccess: (JsonElement) -> T): NetworkResponse<T, FailedResponse> {
    return when (this) {
      is NetworkResponse.Success -> NetworkResponse.Success(onSuccess(this.body), this.headers, this.code)
      is NetworkResponse.ServerError -> this
      is NetworkResponse.RemoteError -> this
      is NetworkResponse.NetworkError -> this
      is NetworkResponse.UnknownError -> this
      else -> throw IllegalStateException("Unsupported response type")
    }
  }

}