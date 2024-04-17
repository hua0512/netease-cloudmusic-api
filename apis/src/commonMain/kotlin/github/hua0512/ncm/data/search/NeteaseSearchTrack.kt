package github.hua0512.ncm.data.search

import github.hua0512.ncm.data.album.NeteaseAlbumArtistsDetailed
import github.hua0512.ncm.data.album.NeteaseAlbumDetailed
import github.hua0512.ncm.data.artist.NeteaseArtistDetailed
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author hua0512
 * @date : 2024/4/12 14:59
 */
@Serializable
data class NeteaseSearchTrack(
    @SerialName("album")
    val album: NeteaseAlbumArtistsDetailed,
    @SerialName("alias")
    val alias: List<String>? = null,
    @SerialName("artists")
    val artists: List<NeteaseArtistDetailed>,
    @SerialName("copyrightId")
    val copyrightId: Int,
    @SerialName("duration")
    val duration: Int,
    @SerialName("fee")
    val fee: Int,
    @SerialName("ftype")
    val ftype: Int = 0,
    @SerialName("id")
    val id: Int,
    @SerialName("mark")
    val mark: Long,
    @SerialName("mvid")
    val mvid: Int,
    @SerialName("name")
    val name: String,
    @SerialName("rUrl")
    val rUrl: String? = null,
    @SerialName("rtype")
    val rtype: Int = 0,
    @SerialName("status")
    val status: Int
)


