package github.hua0512.ncm.data.track

import kotlinx.serialization.Serializable

/**
 * @author hua0512
 * @date : 2024/4/12 0:50
 */
@Serializable
data class NeteaseTrialInfo(
  val fragmentType: Int,
  val start: Long,
  val end: Long,
  val algData: NeteaseTrialInfoAlgData? = null,
)

@Serializable
data class NeteaseTrialInfoAlgData(
  val audioEffect: Int,
)
