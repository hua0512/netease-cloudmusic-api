package github.hua0512.ncm.data.playlist


import github.hua0512.ncm.data.NeteaseResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteasePlaylistSimpleInfo(
    @SerialName("bookedCount")
    val bookedCount: Int,
    @SerialName("commentCount")
    val commentCount: Int,
    @SerialName("followed")
    val followed: Boolean,
    @SerialName("gradeStatus")
    val gradeStatus: String,
    @SerialName("playCount")
    val playCount: Int,
    @SerialName("remarkName")
    val remarkName: String? = null,
    @SerialName("remixVideo")
    val remixVideo: String? = null,
    @SerialName("shareCount")
    val shareCount: Int,
    @SerialName("subscribed")
    val subscribed: Boolean
) : NeteaseResponse()