package github.hua0512.ncm.data.voice


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseVoiceUiElement(
  @SerialName("button")
  var button: String?,
  @SerialName("desc")
  var desc: String?,
  @SerialName("image")
  var image: NeteaseVoiceUiImage,
  @SerialName("imageTag")
  var imageTag: String?,
  @SerialName("mainTitle")
  var mainTitle: NeteaseVoiceUiMainTitle,
  @SerialName("more")
  var more: String?,
  @SerialName("rightButton")
  var rightButton: String?,
  @SerialName("subTitle")
  var subTitle: String?,
  @SerialName("tag")
  var tag: String?,
)