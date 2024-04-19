package github.hua0512.ncm.data.account

import kotlinx.serialization.Serializable


@Serializable
data class NeteaseProfile(
  val avatarImgIdStr: String? = "",
  val followed: Boolean,
  val backgroundUrl: String? = "",
  val backgroundImgIdStr: String? = "",
  val vipType: Int = 0,
  val djStatus: Int = 0,
  val detailDescription: String? = "",
  val accountStatus: Int = 0,
  /**
   * Birthday, can be negative if not set
   * -2209017600000
   */
  val birthday: Long = Long.MIN_VALUE,
  val gender: Int = 0,
  val province: Int = 1000000,
  val city: Int = 1006600,
  val avatarImgId: Long = 0,
  val backgroundImgId: Long = 0,
  val defaultAvatar: Boolean = false,
  val mutual: Boolean = false,
  val remarkName: String? = "",
  val description: String? = "",
  val signature: String? = "",
  val authority: Int = 0,
  val followeds: Int = 0,
  val follows: Int = 0,
  val followTime: Long? = null,
  val followMe: Boolean? = false,
  val newFollows: Int? = 0,
  val eventCount: Int = 0,
  val avatarDetail: NeteaseAvatarDetail? = null,
  val playlistCount: Int = 0,
  val playlistBeSubscribedCount: Int = 0,
  val createTime: Long = 0,
  val lastLoginTime: Long = 0,
  val lastLoginIP: String? = "",
  val privacyItemUnlimited: NeteaseUserPrivacy? = null,
  val blacklist: Boolean? = false,
  val anchor: Boolean? = false,
  val brand: String? = null,
) : NeteaseBaseProfile()