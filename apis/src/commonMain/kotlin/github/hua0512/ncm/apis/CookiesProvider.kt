package github.hua0512.ncm.apis

import io.ktor.http.*

object CookiesProvider {


  private val cookiesMap = mutableMapOf<String, String>()

  val cookies: String?
    get() {
      return if (cookiesMap.isEmpty()) {
        null
      } else {
        cookiesMap.map { "${it.key}=${it.value}" }.joinToString("; ")
      }
    }

  init {
    // try to load cookies from resourcesç
    parseServerSetCookieHeader()
  }

  private fun parseServerSetCookieHeader() {
    val cookies = CookiesProvider::class.java.getResource("/cookies")?.readText() ?: return
    parseServerSetCookieHeader(cookies).also {
      val extensions = it.extensions
      cookiesMap[it.name] = it.value
//            cookiesList.add(Cookie(it.name, it.value, it.encoding, it.maxAge, it.expires, it.domain, it.path, it.secure, it.httpOnly))
      extensions.forEach { (t, u) ->
        cookiesMap[t] = u ?: ""
//                cookiesList.add(Cookie(t, u ?: "", it.encoding, it.maxAge, it.expires, it.domain, it.path, it.secure, it.httpOnly))
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
    cookiesMap.putIfAbsent(key, value)
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