package github.hua0512.ncm.data.search

import github.hua0512.ncm.data.NeteaseResponse
import github.hua0512.ncm.data.account.NeteaseProfile
import github.hua0512.ncm.data.album.NeteaseAlbumDetailed
import github.hua0512.ncm.data.artist.NeteaseArtistDetailed
import github.hua0512.ncm.data.dj.NeteaseDj
import github.hua0512.ncm.data.mv.NeteaseBaseVideo
import github.hua0512.ncm.data.playlist.NeteaseBasePlaylist
import github.hua0512.ncm.data.query.NeteaseSimilarQuery
import github.hua0512.ncm.data.track.NeteaseTrack
import kotlinx.serialization.SerialName
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
        val albums: List<NeteaseAlbumDetailed>,
        val albumCount: Int,
    ) : NeteaseSearchResponse()


    @Serializable
    data class Artists(
        val artists: List<NeteaseArtistDetailed>,
        val artistCount: Int,
        val hasMore: Boolean
    ) : NeteaseSearchResponse()

    @Serializable
    data class Playlists(
        val playlists: List<NeteaseBasePlaylist>,
        val playlistCount: Int,
        val hasMore: Boolean
    ) : NeteaseSearchResponse()

    @Serializable
    data class Users(
        @SerialName("userprofiles")
        val users: List<NeteaseProfile>,
        @SerialName("userprofileCount")
        val userCount: Int,
        val hasMore: Boolean
    ) : NeteaseSearchResponse()


    @Serializable
    data class Mvs(
        @SerialName("mvs")
        val mvs: List<NeteaseBaseVideo>,
        @SerialName("mvCount")
        val mvCount: Int,
        @SerialName("hasMore")
        val hasMore: Boolean? = false
    ) : NeteaseSearchResponse()


    @Serializable
    data class Lyrics(
        @SerialName("songs")
        val tracks: List<NeteaseSearchTrack>,
        @SerialName("songCount")
        val tracksCount: Int,
        @SerialName("hasMore")
        val hasMore: Boolean? = false
    ) : NeteaseSearchResponse()

    @Serializable
    data class Radios(
        @SerialName("djRadios")
        val radios: List<NeteaseDj>,
        @SerialName("djRadiosCount")
        val radioCount: Int,
        @SerialName("hasMore")
        val hasMore: Boolean? = false
    ) : NeteaseSearchResponse()

    @Serializable
    data class Videos(
        @SerialName("videos")
        val videos: List<NeteaseBaseVideo>? = emptyList(),
        @SerialName("videoCount")
        val videoCount: Int? = 0,
        @SerialName("hasMore")
        val hasMore: Boolean? = false
    ) : NeteaseSearchResponse()

    @Serializable
    data class General(
        @SerialName("song")
        val tracks: GeneralItem.Tracks? = null,
        @SerialName("playlists")
        val playlists: GeneralItem.Playlists? = null,
        @SerialName("artist")
        val artists: GeneralItem.Artists? = null,
        @SerialName("album")
        val albums: GeneralItem.Albums? = null,
        @SerialName("user")
        val user: GeneralItem.Users? = null,
        @SerialName("sim_query")
        val similar: GeneralItem.SimilarQuery? = null,
        val order: List<String>,
    ) : NeteaseSearchResponse()


    @Serializable
    sealed class GeneralItem {

        @SerialName("moreText")
        var moreText: String? = null

        @SerialName("more")
        var more: Boolean? = false

        @SerialName("resourceIds")
        val resourceIds: List<String> = emptyList()


        @Serializable
        data class Tracks(
            @SerialName("songs")
            val songs: List<NeteaseTrack>,
            @SerialName("highText")
            val highText: String? = null,
        ) : GeneralItem()

        @Serializable
        data class Playlists(
            @SerialName("playlists")
            val playlists: List<NeteaseBasePlaylist>,
        ) : GeneralItem()

        @Serializable
        data class Artists(
            @SerialName("artists")
            val artists: List<NeteaseArtistDetailed>,
        ) : GeneralItem()

        @Serializable
        data class Albums(
            @SerialName("albums")
            val albums: List<NeteaseAlbumDetailed>,
        ) : GeneralItem()

        @Serializable
        data class SimilarQuery(
            @SerialName("sim_querys")
            val similar: List<NeteaseSimilarQuery>,
        ) : GeneralItem()

        @Serializable
        data class Users(
            @SerialName("users")
            val users: List<NeteaseProfile>,
        ) : GeneralItem()

    }
}