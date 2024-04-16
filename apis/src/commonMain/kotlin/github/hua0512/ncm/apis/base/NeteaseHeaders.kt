package github.hua0512.ncm.apis.base

import github.hua0512.ncm.apis.CookiesProvider
import github.hua0512.ncm.apis.base.NeteaseHeaders.MUSIC_A
import github.hua0512.ncm.apis.base.NeteaseHeaders.MUSIC_U
import kotlinx.datetime.Clock

/**
 * @author hua0512
 * @date : 2024/4/13 22:20
 */

object NeteaseHeaders {
    const val MUSIC_U = "MUSIC_U"
    const val MUSIC_A = "MUSIC_A"
    const val NUID = "_ntes_nuid"
    const val NMTID = "NMTID"
    const val REMEMBER_ME = "__remember_me"

    const val X_REAL_IP = "X-Real-IP"

}

object NeteaseSubHeaders {
    internal const val CSRF_TOKEN = "__csrf"
    internal const val OS = "os"
    internal const val OS_VER = "osver"
    internal const val APP_VER = "appver"
    internal const val VERSION_CODE = "versioncode"
    internal const val BUILD_VER = "buildver"
    internal const val RESOLUTION = "resolution"
    internal const val REQUEST_ID = "requestId"
    internal const val DEVICE_ID = "deviceId"
    internal const val MOBILE_NAME = "mobilename"
    internal const val CHANNEL = "channel"

    internal const val APP_VER_STRING = "8.20.21"
    internal const val IOS = "ios"


    fun getHeaders(provider: CookiesProvider): Map<String, String> {
        return mutableMapOf(
            CSRF_TOKEN to (provider.getCookie(CSRF_TOKEN) ?: ""),
            OS to IOS,
            OS_VER to (provider.getCookie(OS_VER) ?: "17,1,2"),
            APP_VER to (provider.getCookie(APP_VER) ?: APP_VER_STRING),
            VERSION_CODE to (provider.getCookie(VERSION_CODE) ?: "140"),
            BUILD_VER to (provider.getCookie(BUILD_VER) ?: Clock.System.now().epochSeconds.toString()),
            RESOLUTION to (provider.getCookie(RESOLUTION) ?: "1920x1080"),
            REQUEST_ID to (provider.getCookie(REQUEST_ID) ?: "${Clock.System.now().epochSeconds}_${
                (0 until 1000).random().toString().padStart(4, '0')
            }"),
        ).apply {
            provider.getCookie(DEVICE_ID)?.let { put(DEVICE_ID, it) }
            provider.getCookie(MOBILE_NAME)?.let { put(MOBILE_NAME, it) }
            provider.getCookie(CHANNEL)?.let { put(CHANNEL, it) }
            provider.getCookie(MUSIC_A)?.let { put(MUSIC_A, it) }
            provider.getCookie(MUSIC_U)?.let { put(MUSIC_U, it) }
        }
    }

}