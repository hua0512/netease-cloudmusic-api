package github.hua0512.ncm.data.account

import kotlinx.serialization.Serializable

@Serializable
data class NeteaseUserPoint(
    val userId: Long,
    val balance: Int = 0,
    val updateTime: Long = 0,
    val version: Int = 0,
    val status: Int = 0,
    val blockBalance: Int = 0,
)
