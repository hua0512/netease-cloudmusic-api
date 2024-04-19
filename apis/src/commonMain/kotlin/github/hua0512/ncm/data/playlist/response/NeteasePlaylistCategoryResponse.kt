package github.hua0512.ncm.data.playlist.response


import github.hua0512.ncm.data.NeteaseResponse
import github.hua0512.ncm.data.playlist.CategoriesSerializer
import github.hua0512.ncm.data.playlist.NeteaseCategoryType
import github.hua0512.ncm.data.playlist.NeteasePlaylistCategory
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteasePlaylistCategoryResponse(
  @SerialName("all")
  val all: NeteasePlaylistCategory,
  @SerialName("categories")
  @Serializable(with = CategoriesSerializer::class)
  val categories: List<NeteaseCategoryType>,
  @SerialName("sub")
  val sub: List<NeteasePlaylistCategory>,
) : NeteaseResponse()