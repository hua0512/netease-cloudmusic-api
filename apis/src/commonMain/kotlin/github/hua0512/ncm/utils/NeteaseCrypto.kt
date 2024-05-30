@file:OptIn(ExperimentalStdlibApi::class)

package github.hua0512.ncm.utils

import github.hua0512.ncm.utils.Crypto.aesECBDecrypt
import github.hua0512.ncm.utils.Crypto.aesECBEncrypt
import github.hua0512.ncm.utils.Crypto.rsaEncrypt
import github.hua0512.ncm.utils.encryption.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.JsonObject
import kotlin.random.Random

/**
 * @author hua0512
 * @date : 2024/4/16 14:56
 */


private const val iv = "0102030405060708"
private const val presetKey = "0CoJUm6Qyw8W8jud"
private const val base62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
private const val publicKey = """-----BEGIN PUBLIC KEY-----
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDgtQn2JZ34ZC28NWYpAUd98iZ37BUrX/aKzmFbt7clFSs6sXqHauqKWqdtLkF2KexO40H1YTX8z2lSgBBOAxLsvaklV8k4cBFK9snQXE9/DDaFt6Rr7iVZMldczhC0JNgTz+SHXT6CBHuX3e9SdB1Ua44oncaTWz7OBGLbCiK45wIDAQAB
-----END PUBLIC KEY-----"""
private const val eapiKey = "e82ckenh8dichen8"


internal suspend fun weapiEncrypt(data: JsonObject): Map<String, String> {
  val json = json.encodeToString(data)
  val secretKey = buildString {
    for (i in 0 until 16) {
      append(base62[Random.nextInt(62)])
    }
  }
  return mapOf(
    "params" to base64Encode(
      aesEncrypt(
        base64Encode(aesEncrypt(json, AESMode.CBC, AESPadding.PKCS5Padding, presetKey, iv)),
        AESMode.CBC,
        AESPadding.PKCS5Padding,
        secretKey,
        iv
      )
    ),
    "encSecKey" to rsaEncrypt(
      secretKey.reversed(),
      base64Decode(publicKey.replace("-----BEGIN PUBLIC KEY-----\n", "").replace("\n-----END PUBLIC KEY-----", ""))
    ).toHexString()
  )
}

internal suspend fun eapiEncrypt(url: String, data: JsonObject): String {
  val text = json.encodeToString(data)
  val message = "nobody${url}use${text}md5forencrypt"
  val digest = message.toMd5()
  val final = "$url-36cd479b6b5-$text-36cd479b6b5-$digest"
  return aesECBEncrypt(final, eapiKey, paddingMode = AESPadding.PKCS5Padding).toHexString(HexFormat.UpperCase)
}


internal fun eapiDecrypt(cipher: String): String {
  val decodedCipher = base64Decode(cipher)
  return aesECBDecrypt(decodedCipher.decodeToString(), eapiKey, AESPadding.PKCS5Padding).decodeToString()
}
