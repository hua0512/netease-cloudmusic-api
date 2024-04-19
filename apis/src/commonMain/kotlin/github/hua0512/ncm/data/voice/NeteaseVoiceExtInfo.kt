package github.hua0512.ncm.data.voice


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseVoiceExtInfo(
  @SerialName("popularity")
  var popularity: Int,
  @SerialName("showVideoTip")
  var showVideoTip: Boolean,
  @SerialName("vertical")
  var vertical: Boolean,
)