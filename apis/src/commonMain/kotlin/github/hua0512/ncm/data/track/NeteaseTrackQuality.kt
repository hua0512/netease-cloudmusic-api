package github.hua0512.ncm.data.track

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

/**
 * @author hua0512
 * @date : 2024/4/7 21:36
 */
@Serializable
data class NeteaseTrackQuality(
  @JsonNames("br", "bitrate")
  val bitrate: Int,
  @JsonNames("fid", "id")
  val id: Long,
  @SerialName("size")
  val size: Long,
  @SerialName("sr")
  val sr: Int? = null,
  @JsonNames("vd", "volumeDelta")
  val volumeDelta: Double,
  @SerialName("extension")
  val extension: String? = null,
  @SerialName("dfsId")
  val dfsId: Long? = null,
  @SerialName("playTime")
  val playTime: Int? = null,
)
