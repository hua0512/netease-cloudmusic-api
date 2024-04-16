package github.hua0512.ncm.data.location

import github.hua0512.ncm.data.NeteaseResponse
import kotlinx.serialization.Serializable


@Serializable
data class NeteaseCountryResponse(
    val data: List<NeteaseCountryGroup> = listOf()
) : NeteaseResponse()