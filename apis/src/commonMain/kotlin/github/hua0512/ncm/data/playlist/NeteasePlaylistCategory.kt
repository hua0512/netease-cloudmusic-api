package github.hua0512.ncm.data.playlist


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteasePlaylistCategory(
  @SerialName("activity")
  val activity: Boolean,
  @SerialName("category")
  val category: Int,
  @SerialName("hot")
  val hot: Boolean,
  @SerialName("imgId")
  val imgId: Int,
  @SerialName("imgUrl")
  val imgUrl: String? = null,
  @SerialName("name")
  val name: String,
  @SerialName("resourceCount")
  val resourceCount: Int,
  @SerialName("resourceType")
  val resourceType: Int,
  @SerialName("type")
  val type: Int,
)