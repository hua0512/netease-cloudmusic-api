package github.hua0512.ncm.apis.user

import github.hua0512.ncm.apis.base.BaseNeteaseNetworkImpl
import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.account.NeteaseAccountResponse
import github.hua0512.ncm.data.account.NeteaseUserDetail
import github.hua0512.ncm.data.account.NeteaseUserLevelData
import github.hua0512.ncm.data.playlist.response.NeteasePlaylistResponse.UserPlayList
import github.hua0512.ncm.utils.json
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.json.*

class AccountImpl(client: HttpClient) : BaseNeteaseNetworkImpl(client), IAccount {

    override suspend fun getUserDetailsInfo(uid: String): NetworkResponse<NeteaseUserDetail, FailedResponse> =
        postApi(pathName = "/weapi/v1/user/detail/$uid")

    override suspend fun getAccountInfo(): NetworkResponse<NeteaseAccountResponse.Account, FailedResponse> =
        postApi<NeteaseAccountResponse.Account, FailedResponse>(pathName = "/api/nuser/account/get")

    override suspend fun getSubCountInfo(): NetworkResponse<NeteaseAccountResponse.SubAccount, FailedResponse> = postApi(pathName = "/api/subcount")

    override suspend fun getUserLevelInfo(): NetworkResponse<NeteaseUserLevelData, FailedResponse> =
        postApi<JsonObject, FailedResponse>(pathName = "/weapi/user/level").run {
            when (this) {
                is NetworkResponse.Success -> {
                    val code =
                        body["code"]?.jsonPrimitive?.intOrNull ?: return NetworkResponse.UnknownError(IllegalStateException("response code is null"))
                    if (code != 200) {
                        return NetworkResponse.ServerError(json.decodeFromJsonElement(body), code, this.headers)
                    }
                    val data = body["data"] ?: return NetworkResponse.UnknownError(IllegalStateException("argument data is null"))
                    return NetworkResponse.Success(json.decodeFromJsonElement(NeteaseUserLevelData.serializer(), data), this.headers, this.code)
                }

                is NetworkResponse.Error -> {
                    return NetworkResponse.UnknownError(this.error)
                }

                else -> {
                    throw IllegalStateException("Unexpected response type")
                }
            }
        }

    override suspend fun getUserBindingInfo(uid: String): NetworkResponse<NeteaseAccountResponse.Bindings, FailedResponse> =
        postApi(pathName = "/api/v1/user/bindings/$uid")

    override suspend fun getPrivateNotificationsCount(): NetworkResponse<NeteaseAccountResponse.PrivateNotificationCount, FailedResponse> =
        postApi(pathName = "/weapi/pl/count")

    override suspend fun getUserPlaylist(uid: String, limit: Int?, offset: Int?): NetworkResponse<UserPlayList, FailedResponse> =
        postApi(pathName = "/api/user/playlist") {
            parameter("uid", uid)
            parameter("limit", limit ?: 30)
            parameter("offset", offset ?: 0)
            parameter("includeVideo", true)
    }

}