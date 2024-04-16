package github.hua0512.ncm.data.track

import github.hua0512.ncm.data.artist.NeteaseBaseArtist
import kotlinx.serialization.Serializable

/**
 * @author hua0512
 * @date : 2024/4/8 22:02
 */
@Serializable
data class NeteaseOriginTrackData(
    val songId: Long,
    val name: String,
    val artists: List<NeteaseBaseArtist>,
    val albumMeta: NeteaseMusicAlbum,
)

