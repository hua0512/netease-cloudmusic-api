package github.hua0512.ncm.utils

import io.ktor.http.*
import okhttp3.internal.toImmutableList

/**
 * Simple JVM cookies storage provider
 * @author hua0512
 * @date : 2024/5/30 21:02
 */

actual object CookiesStorage {

  actual fun getCookies(): List<Cookie> {
    // get from resources
    return parseResourcesCookies()
  }

  private fun parseResourcesCookies(): List<Cookie> {
    val cookies = CookiesStorage::class.java.getResource("/cookies")?.readText() ?: return emptyList()

    return mutableListOf<Cookie>().apply {
      parseServerSetCookieHeader(cookies).also {
        val extensions = it.extensions
        add(Cookie(it.name, it.value, it.encoding, it.maxAge, it.expires, it.domain, it.path, it.secure, it.httpOnly))
        extensions.forEach { (t, u) ->
          add(Cookie(t, u ?: "", it.encoding, it.maxAge, it.expires, it.domain, it.path, it.secure, it.httpOnly))
        }
      }
    }.toImmutableList()
  }

}