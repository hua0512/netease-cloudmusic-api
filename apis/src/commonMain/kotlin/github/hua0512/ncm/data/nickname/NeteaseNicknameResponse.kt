package github.hua0512.ncm.data.nickname

import github.hua0512.ncm.data.NeteaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseNicknameResponse(
  val nickname: String = "",
  val candidateNicknames: List<String> = emptyList(),
  val duplicated: Boolean = false,
) : NeteaseResponse()