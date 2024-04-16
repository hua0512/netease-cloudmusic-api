package github.hua0512.ncm.apis.login

import github.hua0512.ncm.apis.base.BaseNeteaseNetworkImpl
import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.login.NeteaseLoginResponse
import github.hua0512.ncm.data.login.NeteaseLoginStatusResponse
import github.hua0512.ncm.utils.toMd5
import io.ktor.client.*
import io.ktor.client.request.*

class LoginImpl(client: HttpClient) : BaseNeteaseNetworkImpl(client), ILogin {
    override suspend fun loginByEmail(email: String, password: String, md5Password: String?): NetworkResponse<NeteaseLoginResponse, FailedResponse> {
        return postApi<NeteaseLoginResponse, FailedResponse>(pathName = "/api/login") {
            parameter("username", email)
            parameter("password", md5Password ?: password)
            parameter("rememberLogin", true)
        }
    }

    override suspend fun loginByPhone(
        phone: String,
        password: String,
        countryCode: String?,
        md5Password: String?,
        captcha: String?
    ): NetworkResponse<NeteaseLoginResponse, FailedResponse> {
        return postApi<NeteaseLoginResponse, FailedResponse>(pathName = "/weapi/login/cellphone") {
            parameter("phone", phone)
            parameter("countrycode", countryCode ?: "86")
            captcha?.let { parameter("captcha", it) } ?: md5Password?.let { parameter("password", it) } ?: parameter("password", password.toMd5())
            parameter("rememberLogin", true)
        }
    }

    override suspend fun loginStatus(): NetworkResponse<NeteaseLoginStatusResponse, FailedResponse> {
        return postApi(pathName = "/weapi/w/nuser/account/get")
    }
}