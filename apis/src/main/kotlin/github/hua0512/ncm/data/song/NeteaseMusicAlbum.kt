package github.hua0512.ncm.data.song


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseMusicAlbum(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("pic")
    val pic: Long? = null,
    @SerialName("pic_str")
    val picStr: String? = null,
    @SerialName("picUrl")
    val picUrl: String? = null,
    @SerialName("tns")
    val tns: List<String>? = emptyList(),
)