package github.hua0512.ncm.data.track


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseTrackFreeTrialPrivilege(
  @SerialName("cannotListenReason")
  val cannotListenReason: String?,
  @SerialName("listenType")
  val listenType: String?,
  @SerialName("playReason")
  val playReason: String?,
  @SerialName("resConsumable")
  val resConsumable: Boolean,
  @SerialName("userConsumable")
  val userConsumable: Boolean,
)