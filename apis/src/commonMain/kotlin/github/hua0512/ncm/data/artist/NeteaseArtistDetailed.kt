package github.hua0512.ncm.data.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class NeteaseArtistDetailed(
  @SerialName("albumSize")
  val albumSize: Int,
  @SerialName("fansGroup")
  val fansGroup: String? = null,
  @JsonNames("img1v1", "img1v1Id")
  val img1v1: Long,
  @SerialName("img1v1Url")
  val img1v1Url: String,
  @SerialName("picId")
  val picId: Long,
  @SerialName("picUrl")
  val picUrl: String?,
  // UNKNOW TYPE
  @SerialName("trans")
  val trans: String?,
  val briefDesc: String? = null,
  val musicSize: Int? = null,
  val topicPerson: Int? = null,
  @SerialName("picId_str")
  val picIdStr: String? = null,
  @SerialName("img1v1Id_str")
  val img1v1IdStr: String? = null,
  val alia: List<String>? = emptyList(),
  val mvSize: Int? = null,
  val followed: Boolean? = null,
  val alg: String? = null,
  val accountId: Long? = null,
  val identityIconUrl: String? = null,
) : NeteaseBaseArtist()