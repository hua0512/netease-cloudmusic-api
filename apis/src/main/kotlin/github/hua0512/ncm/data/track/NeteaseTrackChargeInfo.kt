package github.hua0512.ncm.data.track


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseTrackChargeInfo(
    @SerialName("chargeMessage")
    val chargeMessage: String? = null,
    @SerialName("chargeType")
    val chargeType: Int,
    @SerialName("chargeUrl")
    val chargeUrl: String? = null,
    @SerialName("rate")
    val rate: Int
)