package github.hua0512.ncm.data.batch

import github.hua0512.ncm.data.NeteaseResponse
import kotlinx.serialization.Serializable

@Serializable
sealed class NeteaseBatchResponse : NeteaseResponse() {

  @Serializable
  data class Single(
    val apiUrl: String? = "",
  ) : NeteaseBatchResponse()

  @Serializable
  data class Multiple(
    val responses: List<Single> = emptyList(),
  ) : NeteaseBatchResponse()

}