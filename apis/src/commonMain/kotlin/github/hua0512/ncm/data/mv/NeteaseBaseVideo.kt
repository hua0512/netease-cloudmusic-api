package github.hua0512.ncm.data.mv

import github.hua0512.ncm.data.artist.NeteaseBaseArtist
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author hua0512
 * @date : 2024/4/17 22:04
 */
@Serializable
data class NeteaseBaseVideo(
    @SerialName("id")
    val id: Long,
    @SerialName("name")
    val name: String,
    @SerialName("cover")
    val cover: String,
    @SerialName("playCount")
    val playCount: Int,
    @SerialName("duration")
    val duration: Int,
    @SerialName("artists")
    val artists: List<NeteaseBaseArtist>,
    @SerialName("briefDesc")
    val briefDesc: String? = null,
    @SerialName("desc")
    val description: String? = null,
    @SerialName("artistName")
    val artistName: String,
    @SerialName("artistId")
    val artistId: Long,
    @SerialName("mark")
    val mark: Int,
    @SerialName("arTransName")
    val arTransName: String,
    @SerialName("transName")
    val transName: String? = null,
    @SerialName("alias")
    val alias: List<String>? = null,
    @SerialName("alg")
    val arg: String? = null
)