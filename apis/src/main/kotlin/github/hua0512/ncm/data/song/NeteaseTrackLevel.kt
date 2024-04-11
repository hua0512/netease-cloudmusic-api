package github.hua0512.ncm.data.song

/**
 * @author hua0512
 * @date : 2024/4/9 14:44
 */
enum class NeteaseTrackLevel(val level: String) {
    /**
     * 标准
     */
    STANDARD("standard"),

    /**
     * 较高品质
     */
    HIGHER("higher"),

    /**
     * 极高品质
     */
    EXHIGH("exhigh"),

    /**
     * 无损品质
     */
    LOSSLESS("lossless"),

    /**
     * Hi-Res品质
     */
    HIRES("hires"),

    /**
     * 高清环绕音效
     */
    JYEFFECT("jyeffect"),

    /**
     * 沉浸环绕声
     */
    SKY("sky"),

    /**
     * 超清母带
     */
    JYMASTER("jymaster"),

}