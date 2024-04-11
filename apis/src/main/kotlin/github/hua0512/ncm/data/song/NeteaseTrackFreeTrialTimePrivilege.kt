package github.hua0512.ncm.data.song


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseTrackFreeTrialTimePrivilege(
    @SerialName("resConsumable")
    val resConsumable: Boolean,
    @SerialName("userConsumable")
    val userConsumable: Boolean,
    val type: Int,
    val remainTime: Int
)