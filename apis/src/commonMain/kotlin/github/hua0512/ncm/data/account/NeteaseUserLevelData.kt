package github.hua0512.ncm.data.account

import kotlinx.serialization.Serializable

@Serializable
data class NeteaseUserLevelData(
    val userId: Long,
    val info: String? = "",
    val progress: Double = 0.0,
    val nextPlayCount: Int = 0,
    val nextLoginCount: Int = 0,
    val nowPlayCount: Int = 0,
    val nowLoginCount: Int = 0,
    val level: Int = 0,
)