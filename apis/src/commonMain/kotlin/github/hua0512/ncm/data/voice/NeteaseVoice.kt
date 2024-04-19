package github.hua0512.ncm.data.voice


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseVoice(
  @SerialName("action")
  var action: String,
  @SerialName("actionType")
  var actionType: String,
  @SerialName("alg")
  var alg: String,
  @SerialName("baseInfo")
  var baseInfo: NeteaseVoiceBaseInfo,
  @SerialName("extInfo")
  var extInfo: NeteaseVoiceExtInfo,
  @SerialName("idInList")
  var idInList: String,
  @SerialName("noCopyrightRcmdStyle")
  var noCopyrightRcmdStyle: Int,
  @SerialName("resourceId")
  var resourceId: String,
  @SerialName("resourceName")
  var resourceName: String,
  @SerialName("resourceType")
  var resourceType: String,
  @SerialName("type")
  var type: String,
  @SerialName("uiElement")
  var uiElement: NeteaseVoiceUiElement,
)