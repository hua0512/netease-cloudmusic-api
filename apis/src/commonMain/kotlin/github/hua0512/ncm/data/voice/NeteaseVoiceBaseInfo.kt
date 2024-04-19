package github.hua0512.ncm.data.voice


import github.hua0512.ncm.data.account.NeteaseProfile
import github.hua0512.ncm.data.dj.NeteaseDj
import github.hua0512.ncm.data.track.NeteaseTrack
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteaseVoiceBaseInfo(
  @SerialName("adjustedPlayCount")
  var adjustedPlayCount: Double,
  @SerialName("algReason")
  var algReason: String? = null,
  @SerialName("auditStatus")
  var auditStatus: Int,
  @SerialName("bdAuditStatus")
  var bdAuditStatus: Int,
  @SerialName("blurCoverUrl")
  var blurCoverUrl: String? = null,
  @SerialName("buyed")
  var buyed: Boolean,
  @SerialName("canReward")
  var canReward: Boolean,
  @SerialName("category")
  var category: String?,
  @SerialName("categoryId")
  var categoryId: Int,
  @SerialName("channels")
  var channels: List<String>,
  @SerialName("commentCount")
  var commentCount: Int,
  @SerialName("commentThreadId")
  var commentThreadId: String,
  @SerialName("coverId")
  var coverId: Long,
  @SerialName("coverUrl")
  var coverUrl: String,
  @SerialName("createEventId")
  var createEventId: Int,
  @SerialName("createTime")
  var createTime: Long,
  @SerialName("description")
  var description: String,
  @SerialName("disPlayStatus")
  var disPlayStatus: String,
  @SerialName("dj")
  var dj: NeteaseProfile? = null,
  @SerialName("djPlayRecordVo")
  var djPlayRecordVo: String? = null,
  @SerialName("duration")
  var duration: Int,
  @SerialName("h5Links")
  var h5Links: List<String>,
  @SerialName("icon")
  var icon: String?,
  @SerialName("id")
  var id: Long,
  @SerialName("latestFreeTryEndPoint")
  var latestFreeTryEndPoint: String? = null,
  @SerialName("latestFreeTryStartPoint")
  var latestFreeTryStartPoint: String? = null,
  @SerialName("likedCount")
  var likedCount: Int,
  @SerialName("listenerCount")
  var listenerCount: Int,
  @SerialName("mainSong")
  var mainSong: NeteaseTrack,
  @SerialName("mainTrackId")
  var mainTrackId: Int,
  @SerialName("name")
  var name: String,
  @SerialName("price")
  var price: Double?,
  @SerialName("privacy")
  var privacy: Boolean,
  @SerialName("programDesc")
  var programDesc: List<NeteaseVoiceProgramDesc>? = null,
  @SerialName("programFeeType")
  var programFeeType: Int,
  @SerialName("pubStatus")
  var pubStatus: Int,
  @SerialName("publish")
  var publish: Boolean,
  @SerialName("radio")
  var radio: NeteaseDj,
  @SerialName("replaceResource")
  var replaceResource: String? = null,
  @SerialName("reward")
  var reward: Boolean,
  @SerialName("scheduledPublishTime")
  var scheduledPublishTime: Long,
  @SerialName("secondCategory")
  var secondCategory: String? = null,
  @SerialName("secondCategoryId")
  var secondCategoryId: Int,
  @SerialName("serialNum")
  var serialNum: Int,
  @SerialName("shareCount")
  var shareCount: Int,
  @SerialName("shortName")
  var shortName: String? = null,
  @SerialName("showAlgReason")
  var showAlgReason: String? = null,
  @SerialName("songs")
  var songs: List<NeteaseTrack>?,
  @SerialName("subscribed")
  var subscribed: Boolean,
  @SerialName("subscribedCount")
  var subscribedCount: Int,
  @SerialName("titbitImages")
  var titbitImages: String? = null,
  @SerialName("titbits")
  var titbits: String? = null,
  @SerialName("trackCount")
  var trackCount: Int,
  @SerialName("updateTime")
  var updateTime: Long,
  @SerialName("userId")
  var userId: Long,
)