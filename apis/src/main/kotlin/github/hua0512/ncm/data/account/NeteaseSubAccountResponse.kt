package github.hua0512.ncm.data.account

import github.hua0512.ncm.data.NeteaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseSubAccountResponse(
    val programCount: Int = 0,
    val djRadioCount: Int = 0,
    val mvCount: Int = 0,
    val artistCount: Int = 0,
    val newProgramCount: Int = 0,
    val createDjRatioCount: Int = 0,
    val createdPlaylistCount: Int = 0,
    val subPlaylistCount: Int = 0,
) : NeteaseResponse()