package github.hua0512.ncm.data.location

import kotlinx.serialization.Serializable

@Serializable
data class NeteaseCountry(
    val zh: String = "",
    val en: String = "",
    val locale: String = "",
    val code: String = ""
)