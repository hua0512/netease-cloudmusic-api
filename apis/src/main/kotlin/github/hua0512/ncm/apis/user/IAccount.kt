package github.hua0512.ncm.apis.user

import github.hua0512.ncm.apis.base.INeteaseApi
import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.account.*
import github.hua0512.ncm.data.playlist.response.NeteasePlaylistResponse.NeteaseUserPlayListResponse

interface IAccount : INeteaseApi {

    /**
     * 获取用户详情
     */
    suspend fun getUserDetailsInfo(uid: String): NetworkResponse<NeteaseUserDetail, FailedResponse>

    /**
     * 获取账号信息
     */
    suspend fun getAccountInfo(): NetworkResponse<NeteaseAccountResponse, FailedResponse>

    /**
     * 获取用户信息 , 歌单，收藏，mv, dj 数量
     */
    suspend fun getSubCountInfo(): NetworkResponse<NeteaseSubAccountResponse, FailedResponse>

    /**
     * 获取用户等级信息
     */
    suspend fun getUserLevelInfo(): NetworkResponse<NeteaseUserLevelResponse, FailedResponse>

    /**
     * 获取用户绑定信息
     */
    suspend fun getUserBindingInfo(uid: String): NetworkResponse<NeteaseBindingsResponse, FailedResponse>


    /**
     * 私信和通知接口
     */
    suspend fun getPrivateNotificationsCount(): NetworkResponse<NeteasePrivateNotificationCount, FailedResponse>


    /**
     * 获取用户歌单
     */
    suspend fun getUserPlaylist(uid: String): NetworkResponse<NeteaseUserPlayListResponse, FailedResponse>

}