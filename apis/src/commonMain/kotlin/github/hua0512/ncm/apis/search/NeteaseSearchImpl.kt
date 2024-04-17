package github.hua0512.ncm.apis.search

import github.hua0512.ncm.apis.base.BaseNeteaseNetworkImpl
import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.search.NeteaseSearchResponse
import github.hua0512.ncm.data.search.NeteaseSearchType
import github.hua0512.ncm.utils.json
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject

/**
 * 搜索接口
 * @author hua0512
 * @date : 2024/4/12 14:20
 */
class NeteaseSearchImpl(client: HttpClient) : BaseNeteaseNetworkImpl(client), ISearch {

    private fun getBody(json: JsonElement): JsonObject? {
        return json.jsonObject["result"]?.jsonObject
    }


    override suspend fun search(
        keywords: String,
        limit: Int?,
        offset: Int?,
        type: NeteaseSearchType?
    ): NetworkResponse<NeteaseSearchResponse, FailedResponse> = postApi<JsonElement, FailedResponse>(pathName = "/weapi/search/get") {
        parameter("s", keywords)
        parameter("type", type?.id ?: NeteaseSearchType.TRACK.id)
        parameter("limit", limit ?: 30)
        parameter("offset", offset ?: 0)
    }.run {
        transform { element ->
            when (type) {
                NeteaseSearchType.TRACK -> element.decodeToSearchType<NeteaseSearchResponse.Tracks>()
                NeteaseSearchType.ALBUM -> element.decodeToSearchType<NeteaseSearchResponse.Albums>()
                NeteaseSearchType.ARTIST -> element.decodeToSearchType<NeteaseSearchResponse.Artists>()
                NeteaseSearchType.PLAYLIST -> element.decodeToSearchType<NeteaseSearchResponse.Playlists>()
                else -> throw UnsupportedOperationException("Unsupported search type: $type")
            }
        }
    }


    private inline fun <reified T : NeteaseSearchResponse> JsonElement.decodeToSearchType(): T {
        val result = getBody(this) ?: throw IllegalStateException("No result found in response")
        return json.decodeFromJsonElement(result)
    }
}