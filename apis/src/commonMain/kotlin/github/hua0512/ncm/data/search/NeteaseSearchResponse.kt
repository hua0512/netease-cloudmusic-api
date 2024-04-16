package github.hua0512.ncm.data.search

import github.hua0512.ncm.data.NeteaseResponse
import github.hua0512.ncm.data.artist.NeteaseArtistDetailed
import kotlinx.serialization.Serializable


/**
 * @author hua0512
 * @date : 2024/4/12 14:35
 */
@Serializable
sealed class NeteaseSearchResponse : NeteaseResponse() {

    @Serializable
    data class Tracks(
        val songs: List<NeteaseSearchTrack>,
        val songCount: Int,
        val hasMore: Boolean
    ) : NeteaseSearchResponse()


    @Serializable
    data class Albums(
        val albums: List<NeteaseSearchAlbum>,
        val albumCount: Int,
    ) : NeteaseSearchResponse()


    @Serializable
    data class Artists(
        val artists: List<NeteaseArtistDetailed>,
        val artistCount: Int,
        val hasMore: Boolean
    ) : NeteaseSearchResponse()
}