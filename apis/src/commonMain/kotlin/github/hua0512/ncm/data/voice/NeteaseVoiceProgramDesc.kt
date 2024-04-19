package github.hua0512.ncm.data.voice


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseVoiceProgramDesc(
  @SerialName("content")
  var content: String,
  @SerialName("height")
  var height: Int?,
  @SerialName("id")
  var id: Int,
  @SerialName("imageContentURLInvalid")
  var imageContentURLInvalid: Boolean,
  @SerialName("type")
  var type: Int,
  @SerialName("width")
  var width: Int?,
)