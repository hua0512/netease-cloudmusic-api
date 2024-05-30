package github.hua0512.ncm.utils

import io.ktor.http.*

/**
 * @author hua0512
 * @date : 2024/5/30 21:02
 */

expect object CookiesStorage {

  fun getCookies(): List<Cookie>

}