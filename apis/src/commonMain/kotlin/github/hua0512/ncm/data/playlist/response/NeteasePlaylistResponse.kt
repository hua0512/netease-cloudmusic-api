package github.hua0512.ncm.data.playlist.response

import github.hua0512.ncm.data.NeteaseResponse
import github.hua0512.ncm.data.playlist.NeteasePlaylist
import github.hua0512.ncm.data.track.NeteaseTrack
import github.hua0512.ncm.data.track.NeteaseTrackPrivilege
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author hua0512
 * @date : 2024/4/7 14:26
 */
@Serializable
sealed class NeteasePlaylistResponse : NeteaseResponse() {

  var playlist: List<NeteasePlaylist> = emptyList()
  var total: Int? = 0
  var more: Boolean = false


  @Serializable
  data class HighQualityPlaylist(
    @SerialName("lasttime")
    val lastTime: Long,
  ) : NeteasePlaylistResponse() {

    override fun toString(): String {
      // print info including the parent class
      return "NeteaseHighQualityPlaylistResponse(lastTime=$lastTime, playlist=$playlist, total=$total, more=$more)"
    }
  }

  @Serializable
  data class UserPlayList(
    val version: String,
  ) : NeteasePlaylistResponse() {

    override fun toString(): String {
      return "NeteaseUserPlayListResponse(version='$version', playlist=$playlist, total=$total, more=$more)"
    }
  }

  @Serializable
  data class TopPlaylist(
    val cat: String,
  ) : NeteasePlaylistResponse() {

    override fun toString(): String {
      return "NeteaseTopPlaylistResponse(cat='$cat', playlist=$playlist, total=$total, more=$more)"
    }
  }

  @Serializable
  data class PlaylistDetail(
    val playlist: NeteasePlaylist? = null,
    val privileges: List<NeteaseTrackPrivilege>? = emptyList(),
    val relatedVideos: List<String>? = null,
    val urls: List<String>? = null,
    val resEntrace: String? = null,
    val fromUsers: List<String>? = null,
    val fromUsersCount: Int? = null,
    val songFromUsers: List<String>? = null,
  ) : NeteaseResponse()

  @Serializable
  data class PlaylistTracks(
    val songs: List<NeteaseTrack> = emptyList(),
    val privileges: List<NeteaseTrackPrivilege> = emptyList(),
  ) : NeteaseResponse()


}
