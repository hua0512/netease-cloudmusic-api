package github.hua0512.ncm.data.track

import kotlinx.serialization.Serializable

/**
 * @author hua0512
 * @date : 2024/4/8 14:56
 */
@Serializable
data class NeteaseTrackIdInfo(
  val id: Long,
  val v: Int,
  val t: Int,
  val at: Long,
  val alg: String? = null,
  val uid: Long,
  val rcmdReason: String? = null,
  val sc: String? = null,
  val f: String? = null,
  val sr: String? = null,
)
