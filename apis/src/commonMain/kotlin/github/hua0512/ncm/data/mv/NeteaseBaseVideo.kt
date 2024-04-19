package github.hua0512.ncm.data.mv

import github.hua0512.ncm.data.artist.NeteaseBaseArtist
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

/**
 * @author hua0512
 * @date : 2024/4/17 22:04
 */
@Serializable
data class NeteaseBaseVideo(
  @JsonNames("id", "vid")
  val id: Long,
  @JsonNames("name", "title")
  val name: String,
  @JsonNames("cover", "coverUrl")
  val cover: String,
  @JsonNames("playCount", "playTime")
  val playCount: Int,
  @JsonNames("duration", "durationms")
  val duration: Int,
  @JsonNames("artists", "creator")
  val artists: List<NeteaseBaseArtist>? = null,
  @SerialName("briefDesc")
  val briefDesc: String? = null,
  @SerialName("desc")
  val description: String? = null,
  @SerialName("artistName")
  val artistName: String? = null,
  @SerialName("artistId")
  val artistId: Long? = null,
  @SerialName("mark")
  val mark: Int? = null,
  @SerialName("arTransName")
  val arTransName: String? = null,
  @SerialName("transName")
  val transName: String? = null,
  @SerialName("alias")
  val alias: List<String>? = null,
  @SerialName("alg")
  val arg: String? = null,
)