package github.hua0512.ncm.data.account

import github.hua0512.ncm.data.NeteaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseUserDetail(
    val level: Int = 0,
    val listenSongs: Int = 0,
    val userPoint: NeteaseUserPoint,
    val mobileSign: Boolean = false,
    val pcSign: Boolean = false,
    val profile: NeteaseProfile,
    val peopleCanSeeMyPlayRecord: Boolean = false,
    val bindings: List<NeteaseUserBinding> = emptyList(),
    val adValid: Boolean = false,
    val newUser: Boolean = false,
    val recallUser: Boolean = false,
    val createTime: Long = 0,
    val createDays: Int = 0,
) : NeteaseResponse()