package github.hua0512.ncm.data.album

import github.hua0512.ncm.data.artist.NeteaseArtistDetailed
import github.hua0512.ncm.data.artist.NeteaseBaseArtist
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseAlbumDetailed(
    @SerialName("artist")
    val artist: NeteaseArtistDetailed? = null,
    @SerialName("copyrightId")
    val copyrightId: Int? = null,
    @SerialName("mark")
    val mark: Int? = null,
    @SerialName("picId")
    val picId: Long? = null,
    @SerialName("publishTime")
    val publishTime: Long? = null,
    @SerialName("size")
    val size: Int? = null,
    @SerialName("status")
    val status: Int? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("blurPicUrl")
    val blurPicUrl: String? = null,
    @SerialName("companyId")
    val companyId: Int? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("tags")
    val tags: String? = null,
    @SerialName("company")
    val company: String? = null,
    @SerialName("briefDesc")
    val briefDesc: String? = null,
    @SerialName("artists")
    val artists: List<NeteaseBaseArtist>? = emptyList(),
    @SerialName("commentThreadId")
    val commentThreadId: String? = null,
    @SerialName("paid")
    val paid: Boolean? = null,
    @SerialName("onSale")
    val onSale: Boolean? = null,
    @SerialName("picId_str")
    val picIdStr: String? = null,
    @SerialName("alg")
    val alg: String? = null,
    @SerialName("containedSong")
    val containedSong: String? = null,
) : NeteaseBaseAlbum()