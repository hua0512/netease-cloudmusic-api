package github.hua0512.ncm.data.login

import github.hua0512.ncm.data.NeteaseResponse
import github.hua0512.ncm.data.account.NeteaseAccount
import github.hua0512.ncm.data.account.NeteaseProfile
import github.hua0512.ncm.data.account.NeteaseUserBinding
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseLoginResponse(
    val loginType: Int = 0,
    val account: NeteaseAccount,
    val token: String,
    val profile: NeteaseProfile,
    val bindings: List<NeteaseUserBinding> = emptyList(),
) : NeteaseResponse()