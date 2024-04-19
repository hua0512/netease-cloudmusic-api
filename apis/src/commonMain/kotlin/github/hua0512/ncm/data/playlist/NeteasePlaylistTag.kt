package github.hua0512.ncm.data.playlist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteasePlaylistTag(
  @SerialName("activity")
  val activity: Boolean,
  @SerialName("category")
  val category: Int,
  @SerialName("createTime")
  val createTime: Long,
  @SerialName("hot")
  val hot: Boolean,
  @SerialName("id")
  val id: Int,
  @SerialName("name")
  val name: String,
  @SerialName("playlistTag")
  val playlistTag: NeteasePlaylistTagDetailed,
  @SerialName("position")
  val position: Int,
  @SerialName("type")
  val type: Int,
  @SerialName("usedCount")
  val usedCount: Int,
)