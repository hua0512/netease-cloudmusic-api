package github.hua0512.ncm.data.voice


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseVoiceUiImage(
  @SerialName("action")
  var action: String?,
  @SerialName("actionType")
  var actionType: String?,
  @SerialName("actionUrl")
  var actionUrl: String?,
  @SerialName("height")
  var height: Int?,
  @SerialName("imageType")
  var imageType: String,
  @SerialName("imageUrl")
  var imageUrl: String,
  @SerialName("width")
  var width: Int?,
)