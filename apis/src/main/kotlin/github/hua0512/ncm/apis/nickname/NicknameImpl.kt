package github.hua0512.ncm.apis.nickname

import github.hua0512.ncm.apis.base.BaseNeteaseNetworkImpl
import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.nickname.NeteaseNicknameResponse
import io.ktor.client.*
import io.ktor.client.request.*

class NicknameImpl(client: HttpClient) : BaseNeteaseNetworkImpl(client), INickname {

    override suspend fun checkNick(nickname: String): NetworkResponse<NeteaseNicknameResponse, FailedResponse> {
        // cookies are not needed
        // can be called without login directly
        return postApi(pathName = "/api/nickname/duplicated") {
            parameter("nickname", nickname)
        }
    }

}