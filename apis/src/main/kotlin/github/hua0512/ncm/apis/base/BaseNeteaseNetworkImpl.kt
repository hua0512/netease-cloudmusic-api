package github.hua0512.ncm.apis.base

import github.hua0512.ncm.apis.CookiesProvider
import github.hua0512.ncm.data.RequestMode
import github.hua0512.ncm.data.UserAgent
import github.hua0512.ncm.utils.eapiEncrypt
import github.hua0512.ncm.utils.generateRandomHex
import github.hua0512.ncm.utils.networkResponse
import github.hua0512.ncm.utils.weapiEncrypt
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.datetime.Clock
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

abstract class BaseNeteaseNetworkImpl(open val client: HttpClient) {

    companion object {
        const val BASE_URL = "https://music.163.com"
        const val INTERFACE_BASE_URL = "https://interface3.music.163.com"
        const val REAL_IP = "211.161.244.70"
        const val X_REAL_IP = "X-Real-IP"
    }


    val baseUrl: String = BASE_URL

    suspend inline fun <reified T, reified U> getApi(
        baseUrl: String = this.baseUrl,
        pathName: String = "",
        userAgent: UserAgent = UserAgent.PC,
        mode: RequestMode = RequestMode.WEAPI,
        block: HttpRequestBuilder.() -> Unit = {},
    ) = networkResponse<T, U> {
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
    ) = networkResponse<T, U> {
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
    ) = networkResponse<T, U> {
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
    ) = networkResponse<T, Unit> {
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

    fun HttpRequestBuilder.setNeteaseRequest(mode: RequestMode, userAgent: UserAgent, fullPath: String, baseUrl: String, pathName: String) {
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

        CookiesProvider.addIfNotExists("_ntes_nuid", generateRandomHex(16))
        if (fullPath.indexOf("login") == -1) {
            CookiesProvider.addIfNotExists("NMTID", generateRandomHex(16))
        }

        if (CookiesProvider.getCookie("MUSIC_U") == null) {
            // guest mode
            if (CookiesProvider.getCookie("MUSIC_A") == null) {
                // TODO: IMPLEMENT GUEST MODE
//                CookiesProvider.addCookie("MUSIC_A", generateRandomHex(16))
                CookiesProvider.addIfNotExists("os", "ios")
                CookiesProvider.addIfNotExists("appver", "8.20.21")
            }
        } else {
            CookiesProvider.addIfNotExists("__remember_me", "true")
        }
        when (mode) {
            RequestMode.WEAPI -> {
                val jsonObject = buildJsonObject {
                    this@setNeteaseRequest.url.parameters.build().toMap().forEach { (key, value) ->
                        put(key, value.joinToString(","))
                    }
                    put("__csrf", CookiesProvider.getCookie("__csrf") ?: "")
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
                        put("csrfToken", CookiesProvider.getCookie("__csrf") ?: "")
                        put("osver", CookiesProvider.getCookie("osver") ?: "17,1,2")
                        put("appver", CookiesProvider.getCookie("appver") ?: "8.20.21")
                        put("versioncode", CookiesProvider.getCookie("versioncode") ?: "140")
                        CookiesProvider.getCookie("deviceId")?.let { put("deviceId", it) }
                        CookiesProvider.getCookie("mobilename")?.let { put("mobilename", it) }
                        CookiesProvider.getCookie("channel")?.let { put("channel", it) }
                        put("buildver", CookiesProvider.getCookie("buildver") ?: Clock.System.now().epochSeconds.toString())
                        put("os", "ios")
                        put("resolution", CookiesProvider.getCookie("resolution") ?: "1920x1080")
                        put(
                            "requestId",
                            CookiesProvider.getCookie("uniqueId") ?: "${System.currentTimeMillis()}_${
                                (0 until 1000).random().toString().padStart(4, '0')
                            }"
                        )
                        CookiesProvider.getCookie("MUSIC_A")?.let { put("MUSIC_A", it) }
                        CookiesProvider.getCookie("MUSIC_U")?.let { put("MUSIC_U", it) }
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

}