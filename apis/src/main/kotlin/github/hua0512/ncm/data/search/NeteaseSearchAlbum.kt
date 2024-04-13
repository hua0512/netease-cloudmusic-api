package github.hua0512.ncm.data.search

import github.hua0512.ncm.data.artist.NeteaseArtistDetailed
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseSearchAlbum(
    @SerialName("artist")
    val artist: NeteaseArtistDetailed,
    @SerialName("copyrightId")
    val copyrightId: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("mark")
    val mark: Int,
    @SerialName("name")
    val name: String,
    @SerialName("picId")
    val picId: Long,
    @SerialName("publishTime")
    val publishTime: Long,
    @SerialName("size")
    val size: Int,
    @SerialName("status")
    val status: Int,
    val type: String? = null,
    val blurPicUrl: String? = null,
    val companyId: Int? = null,
    val pic: Long? = null,
    val picUrl: String? = null,
    val description: String? = null,
    val tags: String? = null,
    val company: String? = null,
    val briefDesc: String? = null,
    val artists: List<NeteaseArtistDetailed>? = emptyList(),
    val commentThreadId: String? = null,
    val paid: Boolean? = null,
    val onSale: Boolean? = null,
    @SerialName("picId_str")
    val picIdStr: String? = null,
    val alg: String? = null,
    val containedSong: String? = null,
)