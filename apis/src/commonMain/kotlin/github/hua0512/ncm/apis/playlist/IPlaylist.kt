package github.hua0512.ncm.apis.playlist

import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.batch.NeteaseBatchResponse
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.NeteaseResponse
import github.hua0512.ncm.data.playlist.NeteasePlaylistSimpleInfo
import github.hua0512.ncm.data.playlist.NeteaseTopPlaylistType
import github.hua0512.ncm.data.playlist.response.NeteaseHotPlaylistTagsResponse
import github.hua0512.ncm.data.playlist.response.NeteasePlaylistResponse
import github.hua0512.ncm.data.playlist.response.NeteasePlaylistResponse.*

interface IPlaylist {

    /**
     * 更新歌单
     *
     * @param id 歌单id
     * @param name 歌单名
     * @param desc 歌单描述
     * @param tags 歌单标签 只能用官方规定标签
     */
    suspend fun updatePlaylist(id: String, name: String, desc: String, tags: List<String>): NetworkResponse<NeteaseBatchResponse, FailedResponse>

    /**
     * 调整歌单顺序
     * @param ids 歌单id列表
     */
    suspend fun updatePlaylistOrder(ids: List<String>): NetworkResponse<NeteaseResponse, FailedResponse>


    /**
     * 调整歌曲顺序
     * 说明 : 登录后调用此接口,可以根据歌曲 id 顺序调整歌曲顺序
     * @param playlistId 歌单id
     * @param songIds 歌曲id列表
     */
    suspend fun updatePlaylistSongOrder(playlistId: String, songIds: List<String>): NetworkResponse<String, FailedResponse>

    /**
     * 获取热门歌单分类
     */
    suspend fun getHotPlaylistTags(): NetworkResponse<NeteaseHotPlaylistTagsResponse, FailedResponse>

    /**
     * 获取歌单分类
     */
    suspend fun getCategoryPlaylists(): NetworkResponse<NeteaseResponse, FailedResponse>

    /**
     * 获取精品歌单
     * @param cat 歌单分类 参考 [getCategoryPlaylists]
     * @param limit 取出数量 , 默认为 50
     * @param before 分页参数,取上一页最后一个歌单的 updateTime 获取下一页数据
     */
    suspend fun getHighQualityPlaylists(
        cat: String? = "全部",
        limit: Int? = 50,
        before: Long? = 0
    ): NetworkResponse<NeteasePlaylistResponse.HighQualityPlaylist, FailedResponse>

    /**
     * 歌单 ( 网友精选碟 )
     * @param cat 歌单分类 参考 [getCategoryPlaylists] 例: 全部,华语,欧美,日语,韩语,粤语,小语种,流行,摇滚,民谣,电子,舞曲,说唱,轻音乐,爵士,乡村,R&B/Soul,古典,民族,英伦,金属,朋克,蓝调,雷鬼,世界音乐,拉丁,另类/独立,New Age,古风,后摇,Bossa Nova,清晨,夜晚,学习,工作,午休,下午茶,地铁,驾车,运动,旅行,散步,酒吧,怀旧,清新,浪漫,性感,伤感,治愈,放松,孤独,感动,兴奋,快乐,安静,思念,影视原声,ACG,儿童,校园,游戏,70后,80后,90后,网络歌曲,KTV,经典,翻唱,吉他,钢琴,器乐,榜单,00后
     * @param order 可选值为 'new' 和 'hot', 分别对应最新和最热 , 默认为 'hot'
     * @param limit 取出数量 , 默认为 50
     * @param offset 偏移数量 , 用于分页 , 如 :( 页数 -1)*50, 其中 50 为 limit 的值
     */
    suspend fun getTopPlaylists(
        cat: String? = "全部",
        order: NeteaseTopPlaylistType?,
        limit: Int? = 50,
        offset: Int? = 0
    ): NetworkResponse<TopPlaylist, FailedResponse>


    /**
     * 获取歌单详情
     *
     * 说明 : 歌单能看到歌单名字, 但看不到具体歌单内容 , 调用此接口 , 传入歌单 id, 可 以获取对应歌单内的所有的音乐(未登录状态只能获取不完整的歌单,登录后是完整的)，但是返回的 trackIds 是完整的，tracks 则是不完整的，可拿全部 trackIds 请求一次 track/detail 接口获取所有歌曲的详情
     * @param id 歌单id
     * @param subscribers 歌单最近的n个收藏者,默认为 8
     */
    suspend fun getPlaylistDetail(id: String, subscribers: Int? = 8): NetworkResponse<PlaylistDetail, FailedResponse>

    /**
     * 获取歌单所有歌曲
     * @param id 歌单id
     * @param limit 取出数量 , 默认为 100000
     * @param offset 偏移数量 , 用于分页 , 如 :( 页数 -1)*100000, 其中 100000 为 limit 的值
     * @return 歌单所有歌曲
     */
    suspend fun getPlaylistTracks(id: String, limit: Int? = null, offset: Int? = null): NetworkResponse<PlaylistTracks, FailedResponse>

    suspend fun getPlaylistDetailDynamic(id: String, subscribers: Int? = 8): NetworkResponse<NeteasePlaylistSimpleInfo, FailedResponse>


    suspend fun updatePlaylistCount(id: String): NetworkResponse<NeteaseResponse, FailedResponse>


//    /**
//     * 获取相关歌单
//     * @param id 歌单id
//     */
//    suspend fun getRelatedPlaylist(id: String): NetworkResponse<NeteaseResponse, FailedResponse>
}