package github.hua0512.ncm.data.track

import github.hua0512.ncm.data.album.NeteaseBaseAlbum
import github.hua0512.ncm.data.artist.NeteaseBaseArtist
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author hua0512
 * @date : 2024/4/8 22:02
 */
@Serializable
data class NeteaseOriginTrackData(
  @SerialName("songId")
  val songId: Long,
  @SerialName("name")
  val name: String,
  @SerialName("artists")
  val artists: List<NeteaseBaseArtist>,
  @SerialName("albumMeta")
  val albumMeta: NeteaseBaseAlbum,
)

