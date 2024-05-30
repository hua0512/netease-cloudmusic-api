package github.hua0512.ncm.apis.track

import github.hua0512.ncm.utils.CookiesProvider
import github.hua0512.ncm.apis.base.BaseNeteaseNetworkImpl
import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.RequestMode
import github.hua0512.ncm.data.track.NeteaseTrackLevel
import github.hua0512.ncm.data.track.response.NeteaseTrackResponse.TracksInfo
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * @author hua0512
 * @date : 2024/4/8 22:23
 */
class NeteaseTrackImpl(client: HttpClient) : BaseNeteaseNetworkImpl(client), ITrack {


  override suspend fun getTracksUrl(ids: List<String>, br: Long?): NetworkResponse<TracksInfo, FailedResponse> {
    CookiesProvider.addIfNotExists("os", "pc")
    return postApi(baseUrl = INTERFACE_BASE_URL, pathName = "/api/song/enhance/player/url", mode = RequestMode.EAPI) {
      parameter("ids", idsString(ids))
      parameter("br", br ?: 999000)
    }
  }

  override suspend fun getTracksUrlV1(ids: List<String>, level: NeteaseTrackLevel?): NetworkResponse<TracksInfo, FailedResponse> {
    CookiesProvider.addIfNotExists("os", "android")
    CookiesProvider.addIfNotExists("appver", "8.10.05")
    return postApi(baseUrl = INTERFACE_BASE_URL, pathName = "/api/song/enhance/player/url/v1", mode = RequestMode.EAPI) {
      parameter("ids", idsString(ids))
      parameter("level", level?.level ?: NeteaseTrackLevel.EXHIGH.level)
      parameter("encodeType", "flac")
      if (level == NeteaseTrackLevel.SKY) {
        parameter("immerseType", "c51")
      }
    }
  }

  override suspend fun isPlayable(ids: List<String>, br: Long?): NetworkResponse<TracksInfo, FailedResponse> {
    return postApi<TracksInfo, FailedResponse>(pathName = "/weapi/song/enhance/player/url") {
      parameter("ids", idsString(ids))
      parameter("br", br ?: 999000)
    }.run {
      if (this is NetworkResponse.Success) {
        val data = this.body
        if (data.code == 200) {
          val isPlayable = data.data.all { it.code == 200 }
          if (!isPlayable) {
            return NetworkResponse.ServerError(FailedResponse("亲爱的,暂无版权"), 400)
          }
          return this
        } else {
          NetworkResponse.ServerError(FailedResponse("亲爱的,暂无版权"), 400)
        }
      } else {
        this
      }
    }
  }


  private fun idsString(ids: List<String>): String {
    return ids.joinToString(",", prefix = "[", postfix = "]")
  }

}