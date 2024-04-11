package github.hua0512.ncm.apis.batch

import github.hua0512.ncm.data.NeteaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseBatchUrlResponse(
    val apiUrl: String? = "",
) : NeteaseResponse()