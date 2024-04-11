package github.hua0512.ncm.data.account

import kotlinx.serialization.Serializable

@Serializable
data class NeteaseBindingsResponse(
    val bindings: List<NeteaseUserBinding>
)