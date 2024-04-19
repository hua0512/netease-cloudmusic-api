package github.hua0512.ncm.data.account


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class NeteaseBaseProfile {
  @SerialName("authStatus")
  var authStatus: Int = 0

  @SerialName("avatarUrl")
  var avatarUrl: String = ""

  @SerialName("expertTags")
  var expertTags: List<String>? = emptyList()

  //  @SerialName("experts")
//  val experts: Any?,
  @SerialName("nickname")
  var nickname: String = ""

  @SerialName("userId")
  var userId: Long = 0

  @SerialName("userType")
  var userType: Int = 0

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other == null || this::class != other::class) return false

    other as NeteaseBaseProfile

    if (authStatus != other.authStatus) return false
    if (avatarUrl != other.avatarUrl) return false
    if (expertTags != other.expertTags) return false
    if (nickname != other.nickname) return false
    if (userId != other.userId) return false
    if (userType != other.userType) return false

    return true
  }

  override fun hashCode(): Int {
    var result = authStatus
    result = 31 * result + avatarUrl.hashCode()
    result = 31 * result + (expertTags?.hashCode() ?: 0)
    result = 31 * result + nickname.hashCode()
    result = 31 * result + userId.hashCode()
    result = 31 * result + userType
    return result
  }

}