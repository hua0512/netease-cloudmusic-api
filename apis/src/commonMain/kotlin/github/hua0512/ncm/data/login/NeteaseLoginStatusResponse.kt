package github.hua0512.ncm.data.login

import github.hua0512.ncm.data.NeteaseResponse
import github.hua0512.ncm.data.account.NeteaseAccount
import github.hua0512.ncm.data.account.NeteaseProfile
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseLoginStatusResponse(
  val account: NeteaseAccount,
  val profile: NeteaseProfile,
) : NeteaseResponse()