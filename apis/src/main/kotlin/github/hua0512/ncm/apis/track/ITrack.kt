package github.hua0512.ncm.apis.track

import github.hua0512.ncm.apis.base.INeteaseApi
import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.track.NeteaseTrackLevel
import github.hua0512.ncm.data.track.response.NeteaseTrackResponse.NeteaseTracksInfoResponse

/**
 * @author hua0512
 * @date : 2024/4/8 22:23
 */
interface ITrack : INeteaseApi {


    /**
     *
     * 获取音乐 url
     * 说明 : 使用歌单详情接口后 , 能得到的音乐的 id, 但不能得到的音乐 url, 调用此接口, 传入的音乐 id, 可以获取对应的音乐的 url,未登录状态或者非会员返回试听片段(返回字段包含被截取的正常歌曲的开始时间和结束时间)
     *
     * @param ids 音乐 id
     * @param br 码率,默认设置了 999000 即最大码率,如果要 320k 则可设置为 320000,其他类推
     *
     */
    suspend fun getTracksUrl(ids: List<String>, br: Long? = 999000): NetworkResponse<NeteaseTracksInfoResponse, FailedResponse>

    suspend fun getTracksUrlV1(
        ids: List<String>,
        level: NeteaseTrackLevel? = NeteaseTrackLevel.EXHIGH
    ): NetworkResponse<NeteaseTracksInfoResponse, FailedResponse>

    suspend fun isPlayable(ids: List<String>, br: Long? = 999000): NetworkResponse<NeteaseTracksInfoResponse, FailedResponse>
}