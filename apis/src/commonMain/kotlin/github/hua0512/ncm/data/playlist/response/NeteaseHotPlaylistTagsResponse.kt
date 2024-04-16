package github.hua0512.ncm.data.playlist.response

import github.hua0512.ncm.data.NeteaseResponse
import github.hua0512.ncm.data.playlist.NeteasePlaylistTag
import kotlinx.serialization.Serializable

/**
 * @author hua0512
 * @date : 2024/4/6 22:17
 */
@Serializable
data class NeteaseHotPlaylistTagsResponse(
    val tags: List<NeteasePlaylistTag> = emptyList()
) : NeteaseResponse()