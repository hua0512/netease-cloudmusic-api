package github.hua0512.ncm.data.album

import github.hua0512.ncm.data.artist.NeteaseArtistDetailed
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author hua0512
 * @date : 2024/4/17 14:38
 */
@Serializable
data class NeteaseAlbumArtistsDetailed(

  @SerialName("artist")
  val artist: NeteaseArtistDetailed,
  @SerialName("copyrightId")
  val copyrightId: Int,
  @SerialName("mark")
  val mark: Int,
  @SerialName("picId")
  val picId: Long,
  @SerialName("publishTime")
  val publishTime: Long,
  @SerialName("size")
  val size: Int,
  @SerialName("status")
  val status: Int,
  @SerialName("type")
  val type: String? = null,
  @SerialName("blurPicUrl")
  val blurPicUrl: String? = null,
  @SerialName("companyId")
  val companyId: Int? = null,
  @SerialName("description")
  val description: String? = null,
  @SerialName("tags")
  val tags: String? = null,
  @SerialName("company")
  val company: String? = null,
  @SerialName("briefDesc")
  val briefDesc: String? = null,
  @SerialName("artists")
  val artists: List<NeteaseArtistDetailed>? = emptyList(),
  @SerialName("commentThreadId")
  val commentThreadId: String? = null,
  @SerialName("paid")
  val paid: Boolean? = null,
  @SerialName("onSale")
  val onSale: Boolean? = null,
  @SerialName("picId_str")
  val picIdStr: String? = null,
  @SerialName("alg")
  val alg: String? = null,
  @SerialName("containedSong")
  val containedSong: String? = null,
)