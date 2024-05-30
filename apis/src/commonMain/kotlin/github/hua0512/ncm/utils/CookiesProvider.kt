package github.hua0512.ncm.utils

import io.ktor.http.*
import io.ktor.util.collections.*

object CookiesProvider {


  private val cookiesMap = ConcurrentMap<String, String>()

  val cookies: String?
    get() {
      return if (cookiesMap.isEmpty()) {
        null
      } else {
        cookiesMap.map { "${it.key}=${it.value}" }.joinToString("; ")
      }
    }

  init {
    CookiesStorage.getCookies().let {
      if (it.isNotEmpty()) {
        it.forEach { cookie ->
          cookiesMap[cookie.name] = cookie.value
        }
      }
    }
  }


  fun setCookies(cookies: String) {
    clearCookies()
    cookiesMap.putAll(parseClientCookiesHeader(cookies))
  }

  fun clearCookies() {
    cookiesMap.clear()
  }

  open fun addCookie(key: String, value: String) {
    cookiesMap[key] = value
  }

  open fun addIfNotExists(key: String, value: String) {
    cookiesMap.getOrPut(key) { value }
  }

  open fun updateCookie(key: String, value: String) {
    cookiesMap[key] = value
  }

  open fun getCookie(key: String): String? {
    return cookiesMap[key]
  }

  open fun removeCookie(key: String) {
    cookiesMap.remove(key)
  }
}
