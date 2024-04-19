package github.hua0512.ncm.data.voice


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseVoiceUiMainTitle(
  @SerialName("leftIconUrl")
  var leftIconUrl: String?,
  @SerialName("showType")
  var showType: String,
  @SerialName("title")
  var title: String,
)