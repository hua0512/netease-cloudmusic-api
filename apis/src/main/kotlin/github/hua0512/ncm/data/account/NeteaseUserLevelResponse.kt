package github.hua0512.ncm.data.account

import github.hua0512.ncm.data.NeteaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseUserLevelResponse(
    val data: NeteaseUserLevelData
) : NeteaseResponse()