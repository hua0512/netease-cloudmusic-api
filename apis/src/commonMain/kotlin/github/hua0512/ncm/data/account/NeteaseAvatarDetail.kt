package github.hua0512.ncm.data.account

import kotlinx.serialization.Serializable

/**
 * @author hua0512
 * @date : 2024/4/7 14:14
 */
@Serializable
data class NeteaseAvatarDetail(
    val userType: Int,
    val identityLevel: Int,
    val identityIconUrl: String,
)