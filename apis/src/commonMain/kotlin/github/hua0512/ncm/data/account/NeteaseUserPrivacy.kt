package github.hua0512.ncm.data.account

import kotlinx.serialization.Serializable

@Serializable
data class NeteaseUserPrivacy(
  val area: Boolean = true,
  val college: Boolean = true,
  val gender: Boolean = true,
  val age: Boolean = true,
  val village: Boolean = true,
)
