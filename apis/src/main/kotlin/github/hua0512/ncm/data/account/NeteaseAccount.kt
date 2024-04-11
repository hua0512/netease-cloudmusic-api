package github.hua0512.ncm.data.account

import kotlinx.serialization.Serializable

@Serializable
data class NeteaseAccount(
    val id: Long,
    val userName: String,
    val type: Int = 0,
    val status: Int = 0,
    val whitelistAuthority: Int = 0,
    val createTime: Long = 0,
    val salt: ByteArray = ByteArray(0),
    val tokenVersion: Int = 0,
    val ban: Int = 0,
    val baoyueVersion: Int = 0,
    val donateVersion: Int = 0,
    val vipType: Int = 0,
    val viptypeVersion: Int = 0,
    val anonimousUser: Boolean = false,
    val uninitialized: Boolean = false,
    val paidFee: Boolean = false,
)
