package github.hua0512.ncm.data.lyric

import kotlinx.serialization.Serializable

/**
 * @author hua0512
 * @date : 2024/4/17 22:34
 */
@Serializable
data class NeteaseLyricDisplayRange(
    val first: Int,
    val second: Int
)