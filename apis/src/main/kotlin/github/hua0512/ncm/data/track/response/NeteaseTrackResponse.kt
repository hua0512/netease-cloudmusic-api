package github.hua0512.ncm.data.track.response

import github.hua0512.ncm.data.NeteaseResponse
import github.hua0512.ncm.data.track.NeteaseTrackDownloadInfo
import kotlinx.serialization.Serializable

/**
 * @author hua0512
 * @date : 2024/4/9 14:41
 */
@Serializable
sealed class NeteaseTrackResponse : NeteaseResponse() {

    @Serializable
    data class NeteaseTracksInfoResponse(
        val data: List<NeteaseTrackDownloadInfo>
    ) : NeteaseTrackResponse()
}