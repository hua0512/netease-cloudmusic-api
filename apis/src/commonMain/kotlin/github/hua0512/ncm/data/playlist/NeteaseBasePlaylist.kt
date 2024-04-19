package github.hua0512.ncm.data.playlist


import github.hua0512.ncm.data.account.NeteaseBaseProfile
import github.hua0512.ncm.data.track.NeteaseTrack
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class NeteaseBasePlaylist {

  @SerialName("action")
  var action: String = ""

  @SerialName("actionType")
  var actionType: String = ""

  @SerialName("alg")
  var alg: String = ""

  @SerialName("bookCount")
  var bookCount: Int = 0

  @SerialName("coverImgUrl")
  var coverImgUrl: String = ""

  @SerialName("creator")
  var creator: NeteaseBaseProfile = NeteaseBaseProfile()

  @SerialName("description")
  var description: String = ""

  @SerialName("highQuality")
  var highQuality: Boolean = false

  @SerialName("id")
  var id: Long = 0

  @SerialName("name")
  var name: String = ""

  @SerialName("officialTags")
  var officialTags: List<String>? = emptyList()

  @SerialName("playCount")
  var playCount: Int = 0

  @SerialName("recommendText")
  var recommendText: String? = null

  @SerialName("score")
  var score: String? = null

  @SerialName("specialType")
  var specialType: Int = 0

  @SerialName("subscribed")
  var subscribed: Boolean = false

  @SerialName("track")
  var track: NeteaseTrack? = null

  @SerialName("trackCount")
  var trackCount: Int = 0

  @SerialName("userId")
  var userId: Int = 0

}