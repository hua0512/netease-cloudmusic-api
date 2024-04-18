package github.hua0512.ncm.data.search

import github.hua0512.ncm.data.NeteaseResponse
import github.hua0512.ncm.data.account.NeteaseProfile
import github.hua0512.ncm.data.album.NeteaseAlbumDetailed
import github.hua0512.ncm.data.artist.NeteaseArtistDetailed
import github.hua0512.ncm.data.dj.NeteaseDj
import github.hua0512.ncm.data.mv.NeteaseBaseVideo
import github.hua0512.ncm.data.playlist.NeteaseBasePlaylist
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
}