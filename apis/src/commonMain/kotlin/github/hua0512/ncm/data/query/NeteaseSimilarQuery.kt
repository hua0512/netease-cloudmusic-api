package github.hua0512.ncm.data.query

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author hua0512
 * @date : 2024/4/18 21:44
 */
@Serializable
data class NeteaseSimilarQuery(
  @SerialName("keyword")
  val keyword: String,
  @SerialName("alg")
  val alg: String,
)
