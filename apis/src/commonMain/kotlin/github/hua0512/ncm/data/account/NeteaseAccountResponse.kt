package github.hua0512.ncm.data.account

import github.hua0512.ncm.data.NeteaseResponse
import kotlinx.serialization.Serializable

@Serializable
sealed class NeteaseAccountResponse {

    @Serializable
    data class Account(
        val account: NeteaseAccount,
        val profile: NeteaseProfile,
    ) : NeteaseResponse()

    @Serializable
    data class SubAccount(
        val programCount: Int = 0,
        val djRadioCount: Int = 0,
        val mvCount: Int = 0,
        val artistCount: Int = 0,
        val newProgramCount: Int = 0,
        val createDjRatioCount: Int = 0,
        val createdPlaylistCount: Int = 0,
        val subPlaylistCount: Int = 0,
    ) : NeteaseResponse()

    @Serializable
    data class Bindings(
        val bindings: List<NeteaseUserBinding>
    ) : NeteaseResponse()


    @Serializable
    data class PrivateNotificationCount(
        val notice: Int = 0,
        val follow: Int = 0,
        val forward: Int = 0,
        val msg: Int = 0,
        val comment: Int = 0,
        val totalComments: Int = 0,
        val pushMsg: String? = "",
        val lastPrivateMsg: String? = null,
        val event: Int = 0,
        val newProgramCount: Int = 0,
        val createDJRadioCount: Int = 0,
        val newTheme: Boolean = false,
    ) : NeteaseResponse()

    /**
     * {
     *    "code":200,
     *    "notice":0,
     *    "follow":0,
     *    "forward":0,
     *    "msg":4,
     *    "comment":0,
     *    "sceneComments":{
     *       "musician_comments":0,
     *       "social_comments":0
     *    },
     *    "totalComment":0,
     *    "pushMsg":"你收到了4条消息：4条私信",
     *    "friend":{
     *       "snsCount":0,
     *       "count":0,
     *       "celebrityCount":0
     *    },
     *    "lastPrivateMsg":null,
     *    "event":7,
     *    "newProgramCount":0,
     *    "createDJRadioCount":0,
     *    "newTheme":false,
     *    "battle":{
     *       "showQuizIcon":false,
     *       "startTime":0,
     *       "endTime":0,
     *       "nonStartIcon":null,
     *       "startIcon":null
     *    },
     *    "ydAntiUrlConfigVersion":1,
     *    "invitationVersion":0
     * }
     */
}