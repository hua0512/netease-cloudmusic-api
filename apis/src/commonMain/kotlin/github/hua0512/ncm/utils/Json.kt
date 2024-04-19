package github.hua0512.ncm.utils

import kotlinx.serialization.json.Json

/**
 * @author hua0512
 * @date : 2024/4/15 22:29
 */
val json by lazy {
  Json {
    ignoreUnknownKeys = true
    prettyPrint = false
    isLenient = true
  }
}