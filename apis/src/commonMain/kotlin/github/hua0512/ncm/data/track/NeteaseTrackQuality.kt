package github.hua0512.ncm.data.track

import kotlinx.serialization.Serializable

/**
 * @author hua0512
 * @date : 2024/4/7 21:36
 */
@Serializable
data class NeteaseTrackQuality(
    val br: Int,
    val fid: Int,
    val size: Int,
    val sr: Int? = null,
    val vd: Double
)
