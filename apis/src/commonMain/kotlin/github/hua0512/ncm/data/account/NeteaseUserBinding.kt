package github.hua0512.ncm.data.account

import kotlinx.serialization.Serializable

@Serializable
data class NeteaseUserBinding(
    val tokenJsonStr: String? = null,
    val bindingTime: Long,
    val refreshTime: Long,
    val expiresIn: Long,
    val url: String = "",
    val expired: Boolean = false,
    val userId: Long,
    val id: Long,
    val type: Int = 0,
)