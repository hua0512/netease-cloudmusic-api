package github.hua0512.ncm.apis.batch

import kotlinx.serialization.Serializable

@Serializable
data class NeteaseBatchResponse(
    val responses: List<NeteaseBatchUrlResponse> = emptyList(),
)