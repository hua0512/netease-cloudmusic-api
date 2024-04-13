package github.hua0512.ncm.apis.playlist

import github.hua0512.ncm.apis.CookiesProvider
import github.hua0512.ncm.apis.base.BaseNeteaseNetworkImpl
import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.apis.batch.NeteaseBatchResponse
import github.hua0512.ncm.apis.batch.NeteaseBatchUrlResponse
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.NeteaseResponse
import github.hua0512.ncm.data.RequestMode
import github.hua0512.ncm.data.playlist.NeteasePlaylistSimpleInfo
import github.hua0512.ncm.data.playlist.NeteaseTopPlaylistType
import github.hua0512.ncm.data.playlist.response.NeteaseHotPlaylistTagsResponse
import github.hua0512.ncm.data.playlist.response.NeteasePlaylistCategoryResponse
import github.hua0512.ncm.data.playlist.response.NeteasePlaylistResponse
import github.hua0512.ncm.data.playlist.response.NeteasePlaylistResponse.*
import github.hua0512.ncm.utils.json
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*

class PlaylistImpl(client: HttpClient) : BaseNeteaseNetworkImpl(client), IPlaylist {

    companion object {
        private const val PLAYLIST_UPDATE_DESC = "/api/playlist/desc/update"
        private const val PLAYLIST_UPDATE_TAGS = "/api/playlist/tags/update"
        private const val PLAYLIST_UPDATE_NAME = "/api/playlist/update/name"
    }

    override suspend fun updatePlaylist(
        id: String,
        name: String,
        desc: String,
        tags: List<String>
    ): NetworkResponse<NeteaseBatchResponse, FailedResponse> {
        if (id.isEmpty()) {
            throw IllegalArgumentException("id is empty")
        }
        CookiesProvider.addIfNotExists("os", "pc")
        return postApi<JsonObject, FailedResponse>(pathName = "/weapi/batch/") {
            if (desc.isNotEmpty())
                parameter(PLAYLIST_UPDATE_DESC, buildJsonObject {
                    put("id", id)
                    put("desc", desc)
                })
            if (tags.isNotEmpty())
                parameter(PLAYLIST_UPDATE_TAGS, buildJsonObject {
                    put("id", id)
                    put("tags", tags.joinToString(";")) // tags must be a string separated by ;
                })
            if (name.isNotEmpty())
                parameter(PLAYLIST_UPDATE_NAME, buildJsonObject {
                    put("id", id)
                    put("name", name)
                })
        }.run {
            when (this) {
                is NetworkResponse.Success -> {
                    val jsonData = this.body
                    var code = this.code
                    val urls = jsonData.jsonObject.entries.mapNotNull {
                        if (it.key == "code") {
                            code = it.value.jsonPrimitive.int
                            return@mapNotNull null
                        }
                        val response = json.decodeFromJsonElement<NeteaseResponse>(it.value)
                        NeteaseBatchUrlResponse(it.key).apply {
                            this.code = response.code
                        }
                    }
                    return NetworkResponse.Success(NeteaseBatchResponse(urls), this.headers, code)
                }

                is NetworkResponse.Error -> {
                    return NetworkResponse.UnknownError(this.error, 400)
                }

                else -> throw IllegalStateException("Unknown response type")
            }
        }
    }

    override suspend fun updatePlaylistOrder(ids: List<String>): NetworkResponse<NeteaseResponse, FailedResponse> {
        CookiesProvider.addIfNotExists("os", "pc")
        return postApi<NeteaseResponse, FailedResponse>(pathName = "/api/playlist/order/update") {
            parameter("ids", ids.joinToString(","))
        }
    }

    override suspend fun updatePlaylistSongOrder(playlistId: String, songIds: List<String>): NetworkResponse<String, FailedResponse> {
        return postApi("http://interface.music.163.com", pathName = "/api/playlist/manipulate/tracks") {
            parameter("op", "update")
            parameter("pid", playlistId)
            parameter("trackIds", songIds.joinToString(","))
        }
    }

    override suspend fun getHotPlaylistTags(): NetworkResponse<NeteaseHotPlaylistTagsResponse, FailedResponse> {
        return postApi(pathName = "/weapi/playlist/hottags")
    }

    override suspend fun getCategoryPlaylists(): NetworkResponse<NeteasePlaylistCategoryResponse, FailedResponse> {
        return postApi(pathName = "/weapi/playlist/catalogue")
    }

    override suspend fun getHighQualityPlaylists(
        cat: String?,
        limit: Int?,
        before: Long?
    ): NetworkResponse<NeteaseHighQualityPlaylistResponse, FailedResponse> {
        return postApi(pathName = "/api/playlist/highquality/list") {
            parameter("cat", cat ?: "全部")
            parameter("limit", limit ?: 50)
            parameter("before", before ?: 0)
        }
    }

    override suspend fun getTopPlaylists(
        cat: String?,
        order: NeteaseTopPlaylistType?,
        limit: Int?,
        offset: Int?
    ): NetworkResponse<NeteasePlaylistResponse.NeteaseTopPlaylistResponse, FailedResponse> {
        return postApi(pathName = "/weapi/playlist/list") {
            parameter("cat", cat ?: "全部")
            parameter("order", order?.type ?: NeteaseTopPlaylistType.CLOUD_MUSIC_HOT.type)
            parameter("limit", limit ?: 50)
            parameter("offset", offset ?: 0)
        }
    }

    override suspend fun getPlaylistDetail(id: String, subscribers: Int?): NetworkResponse<NeteasePlaylistDetailResponse, FailedResponse> {
        return postApi(pathName = "/api/v6/playlist/detail", mode = RequestMode.API) {
            parameter("id", id)
            parameter("n", 100000)
            parameter("s", subscribers ?: 8)
        }
    }

    override suspend fun getPlaylistTracks(id: String, limit: Int?, offset: Int?): NetworkResponse<NeteasePlaylistTracksResponse, FailedResponse> {
        when (val playlist = getPlaylistDetail(id)) {
            is NetworkResponse.Success -> {
                val trackIds = playlist.body.playlist?.trackIds?.map { it.id } ?: emptyList()
                // slice ids with limit and offset
                val ids = trackIds.slice((offset ?: 0) until (offset ?: 0) + (limit ?: trackIds.size))
                // convert to map
                val map = ids.map { mapOf("id" to it) }
                return postApi(pathName = "/api/v3/track/detail") {
                    parameter("c", json.encodeToString(map))
                }
            }

            is NetworkResponse.Error -> {
                return NetworkResponse.UnknownError(playlist.error, 400)
            }

            else -> {
                throw IllegalStateException("Unknown response type")
            }
        }
    }

    override suspend fun getPlaylistDetailDynamic(id: String, subscribers: Int?): NetworkResponse<NeteasePlaylistSimpleInfo, FailedResponse> {
        return postApi(pathName = "/api/playlist/detail/dynamic", mode = RequestMode.API) {
            parameter("id", id)
            parameter("n", 100000)
            parameter("s", subscribers ?: 8)
        }
    }

    override suspend fun updatePlaylistCount(id: String): NetworkResponse<NeteaseResponse, FailedResponse> {
        return postApi(pathName = "/api/playlist/update/playcount") {
            parameter("id", id)
        }
    }


}