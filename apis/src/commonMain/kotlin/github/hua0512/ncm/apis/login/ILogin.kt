package github.hua0512.ncm.apis.login

import github.hua0512.ncm.apis.base.INeteaseApi
import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.login.NeteaseLoginResponse
import github.hua0512.ncm.data.login.NeteaseLoginStatusResponse

interface ILogin : INeteaseApi {


  suspend fun loginByEmail(email: String, password: String, md5Password: String?): NetworkResponse<NeteaseLoginResponse, FailedResponse>

  suspend fun loginByPhone(
    phone: String,
    password: String,
    countryCode: String?,
    md5Password: String?,
    captcha: String?,
  ): NetworkResponse<NeteaseLoginResponse, FailedResponse>

  suspend fun loginStatus(): NetworkResponse<NeteaseLoginStatusResponse, FailedResponse>
}