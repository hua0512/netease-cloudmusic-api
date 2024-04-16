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
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject

/**
 * @author hua0512
 * @date : 2024/4/12 14:20
 */
class NeteaseSearchImpl(client: HttpClient) : BaseNeteaseNetworkImpl(client), ISearch {
    override suspend fun search(
        keywords: String,
        limit: Int?,
        offset: Int?,
        type: NeteaseSearchType?
    ): NetworkResponse<NeteaseSearchResponse, FailedResponse> {
        return postApi<JsonElement, FailedResponse>(pathName = "/weapi/search/get") {
            parameter("s", keywords)
            parameter("type", type?.id ?: NeteaseSearchType.TRACK.id)
            parameter("limit", limit ?: 30)
            parameter("offset", offset ?: 0)
        }.run {
            if (this is NetworkResponse.Success) {
                when (type) {
                    NeteaseSearchType.TRACK -> {
                        val result = this.body.jsonObject["result"]?.jsonObject ?: return NetworkResponse.UnknownError(
                            IllegalStateException("Response body is null"),
                            400
                        )

                        val response = json.decodeFromJsonElement<NeteaseSearchResponse.Tracks>(result)
                        return NetworkResponse.Success(response, this.headers, this.code)
                    }

                    NeteaseSearchType.ALBUM -> {
                        val result = this.body.jsonObject["result"]?.jsonObject ?: return NetworkResponse.UnknownError(
                            IllegalStateException("Response body is null"),
                            400
                        )

                        val response = json.decodeFromJsonElement<NeteaseSearchResponse.Albums>(result)
                        return NetworkResponse.Success(response, this.headers, this.code)
                    }

                    NeteaseSearchType.ARTIST -> {
                        val result = this.body.jsonObject["result"]?.jsonObject ?: return NetworkResponse.UnknownError(
                            IllegalStateException("Response body is null"),
                            400
                        )

                        val response = json.decodeFromJsonElement<NeteaseSearchResponse.Artists>(result)
                        return NetworkResponse.Success(response, this.headers, this.code)
                    }

                    else -> throw UnsupportedOperationException("Unsupported search type: $type")
                }
            } else if (this is NetworkResponse.Error) {
                return NetworkResponse.UnknownError(this.error, 400)
            } else {
                throw IllegalStateException("Unknown response type")
            }
        }
    }
}