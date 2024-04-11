package github.hua0512.ncm.apis.user

import github.hua0512.ncm.apis.base.BaseNeteaseNetworkImpl
import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.account.*
import github.hua0512.ncm.data.playlist.response.NeteasePlaylistResponse.NeteaseUserPlayListResponse
import io.ktor.client.*
import io.ktor.client.request.*

class AccountImpl(client: HttpClient) : BaseNeteaseNetworkImpl(client), IAccount {

    override suspend fun getUserDetailsInfo(uid: String): NetworkResponse<NeteaseUserDetail, FailedResponse> =
        postApi(pathName = "/weapi/v1/user/detail/$uid")

    override suspend fun getAccountInfo() = postApi<NeteaseAccountResponse, FailedResponse>(pathName = "/api/nuser/account/get")

    override suspend fun getSubCountInfo(): NetworkResponse<NeteaseSubAccountResponse, FailedResponse> = postApi(pathName = "/api/subcount")

    override suspend fun getUserLevelInfo(): NetworkResponse<NeteaseUserLevelResponse, FailedResponse> = postApi(pathName = "/weapi/user/level")

    override suspend fun getUserBindingInfo(uid: String): NetworkResponse<NeteaseBindingsResponse, FailedResponse> =
        postApi(pathName = "/api/v1/user/bindings/$uid")

    override suspend fun getPrivateNotificationsCount(): NetworkResponse<NeteasePrivateNotificationCount, FailedResponse> =
        postApi(pathName = "/weapi/pl/count")

    override suspend fun getUserPlaylist(uid: String): NetworkResponse<NeteaseUserPlayListResponse, FailedResponse> {
        return postApi(pathName = "/api/user/playlist") {
            parameter("uid", uid)
            parameter("limit", 30)
            parameter("offset", 0)
            parameter("includeVideo", true)
        }
    }

}