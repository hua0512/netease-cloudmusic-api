package github.hua0512.ncm.data

import kotlinx.serialization.Serializable

@Serializable
data class FailedResponse(
  val message: String,
) : NeteaseResponse()