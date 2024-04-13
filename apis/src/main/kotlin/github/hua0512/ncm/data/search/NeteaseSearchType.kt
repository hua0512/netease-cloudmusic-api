package github.hua0512.ncm.data.search

/**
 * @author hua0512
 * @date : 2024/4/12 14:15
 */
enum class NeteaseSearchType(val id: Int) {


    /**
     * 单曲
     */
    TRACK(1),

    /**
     * 专辑
     */
    ALBUM(10),

    /**
     * 歌手
     */
    ARTIST(100),

    /**
     * 歌单
     */
    PLAYLIST(1000),

    /**
     * 用户
     */
    USER(1002),

    /**
     * MV
     */
    MV(1004),

    /**
     * 歌词
     */
    LYRIC(1006),

    /**
     * 电台
     */
    RADIO(1009),

    /**
     * 视频
     */
    VIDEO(1014),

    /**
     * 综合
     */
    GENERAL(1018),

    /**
     * 声音
     */
    VOICE(2000)


}