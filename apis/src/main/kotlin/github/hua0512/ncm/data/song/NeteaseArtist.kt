package github.hua0512.ncm.data.song


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseArtist(
    @SerialName("alias")
    val alias: List<String>? = emptyList(),
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("tns")
    val tns: List<String>? = emptyList()
)