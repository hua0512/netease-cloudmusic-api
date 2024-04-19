package github.hua0512.ncm.data.dj


import github.hua0512.ncm.data.account.NeteaseProfile
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseDj(
  @SerialName("alg")
  var alg: String? = null,
  @SerialName("buyed")
  var buyed: Boolean,
  @SerialName("category")
  var category: String,
  @SerialName("categoryId")
  var categoryId: Int,
  @SerialName("commentCount")
  var commentCount: Int? = null,
  @SerialName("composeVideo")
  var composeVideo: Boolean,
  @SerialName("createTime")
  var createTime: Long,
  @SerialName("desc")
  var desc: String,
  @SerialName("discountPrice")
  var discountPrice: Double? = 0.0,
  @SerialName("dj")
  var dj: NeteaseProfile? = null,
  @SerialName("feeScope")
  var feeScope: Int,
  @SerialName("finished")
  var finished: Boolean,
  @SerialName("hightQuality")
  var hightQuality: Boolean,
  @SerialName("icon")
  var icon: String? = null,
  @SerialName("id")
  var id: Int,
  @SerialName("intervenePicUrl")
  var intervenePicUrl: String,
  @SerialName("lastProgramCreateTime")
  var lastProgramCreateTime: Long,
  @SerialName("lastProgramId")
  var lastProgramId: Long,
  @SerialName("lastProgramName")
  var lastProgramName: String? = null,
  @SerialName("likedCount")
  var likedCount: Int? = null,
//  @SerialName("liveInfo")
//  var liveInfo: Any?,
  @SerialName("name")
  var name: String,
  @SerialName("originalPrice")
  var originalPrice: Int,
  @SerialName("picId")
  var picId: Long,
  @SerialName("picUrl")
  var picUrl: String,
  @SerialName("playCount")
  var playCount: Int,
  @SerialName("price")
  var price: Int,
  @SerialName("privacy")
  var privacy: Boolean,
  @SerialName("programCount")
  var programCount: Int,
  @SerialName("purchaseCount")
  var purchaseCount: Int,
  @SerialName("radioFeeType")
  var radioFeeType: Int,
  @SerialName("rcmdText")
  var rcmdText: String? = null,
  @SerialName("secondCategory")
  var secondCategory: String,
  @SerialName("secondCategoryId")
  var secondCategoryId: Int,
  @SerialName("shareCount")
  var shareCount: Int? = null,
  @SerialName("subCount")
  var subCount: Int,
  @SerialName("underShelf")
  var underShelf: Boolean,
//  @SerialName("videos")
//  var videos: Any?,
  @SerialName("whiteList")
  var whiteList: Boolean,
)