package github.hua0512.ncm.apis.user

import github.hua0512.ncm.apis.base.INeteaseApi
import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.account.NeteaseAccountResponse
import github.hua0512.ncm.data.account.NeteaseAccountResponse.Account
import github.hua0512.ncm.data.account.NeteaseUserDetail
import github.hua0512.ncm.data.account.NeteaseUserLevelData
import github.hua0512.ncm.data.playlist.response.NeteasePlaylistResponse.UserPlayList

interface IAccount : INeteaseApi {

  /**
   * 获取用户详情
   */
  suspend fun getUserDetailsInfo(uid: String): NetworkResponse<NeteaseUserDetail, FailedResponse>

  /**
   * 获取账号信息
   */
  suspend fun getAccountInfo(): NetworkResponse<Account, FailedResponse>

  /**
   * 获取用户信息 , 歌单，收藏，mv, dj 数量
   */
  suspend fun getSubCountInfo(): NetworkResponse<NeteaseAccountResponse.SubAccount, FailedResponse>

  /**
   * 获取用户等级信息
   */
  suspend fun getUserLevelInfo(): NetworkResponse<NeteaseUserLevelData, FailedResponse>

  /**
   * 获取用户绑定信息
   */
  suspend fun getUserBindingInfo(uid: String): NetworkResponse<NeteaseAccountResponse.Bindings, FailedResponse>


  /**
   * 私信和通知接口
   */
  suspend fun getPrivateNotificationsCount(): NetworkResponse<NeteaseAccountResponse.PrivateNotificationCount, FailedResponse>


  /**
   * 获取用户歌单
   * @param uid 用户id
   * @param limit 返回数量
   * @param offset 偏移量
   */
  suspend fun getUserPlaylist(uid: String, limit: Int? = 30, offset: Int? = 0): NetworkResponse<UserPlayList, FailedResponse>

}