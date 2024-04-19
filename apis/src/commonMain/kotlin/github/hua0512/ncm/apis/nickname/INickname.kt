package github.hua0512.ncm.apis.nickname

import github.hua0512.ncm.apis.base.INeteaseApi
import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.nickname.NeteaseNicknameResponse

interface INickname : INeteaseApi {

  suspend fun checkNick(nickname: String): NetworkResponse<NeteaseNicknameResponse, FailedResponse>

}