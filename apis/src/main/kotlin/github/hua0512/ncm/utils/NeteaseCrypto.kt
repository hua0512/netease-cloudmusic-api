package github.hua0512.ncm.utils

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import java.nio.charset.StandardCharsets
import java.security.KeyFactory
import java.security.spec.X509EncodedKeySpec
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

const val iv = "0102030405060708"
const val presetKey = "0CoJUm6Qyw8W8jud"
const val base62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
const val publicKey = """-----BEGIN PUBLIC KEY-----
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDgtQn2JZ34ZC28NWYpAUd98iZ37BUrX/aKzmFbt7clFSs6sXqHauqKWqdtLkF2KexO40H1YTX8z2lSgBBOAxLsvaklV8k4cBFK9snQXE9/DDaFt6Rr7iVZMldczhC0JNgTz+SHXT6CBHuX3e9SdB1Ua44oncaTWz7OBGLbCiK45wIDAQAB
-----END PUBLIC KEY-----"""
const val eapiKey = "e82ckenh8dichen8"
val json by lazy {
    Json {
        ignoreUnknownKeys = true
        prettyPrint = false
        isLenient = true
    }
}


fun aesEncrypt(text: String, mode: String, key: String, iv: String, format: String = "base64"): String {
    val cipher = Cipher.getInstance("AES/$mode/PKCS5Padding")
    val secretKey = SecretKeySpec(key.toByteArray(StandardCharsets.UTF_8), "AES")
    if (iv.isNotEmpty())
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, IvParameterSpec(iv.toByteArray(StandardCharsets.UTF_8)))
    else
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
    val encrypted = cipher.doFinal(text.toByteArray(StandardCharsets.UTF_8))

    return if (format == "base64") {
        Base64.getEncoder().encodeToString(encrypted)
    } else {
        encrypted.joinToString("") { "%02x".format(it) }.uppercase(Locale.getDefault())
    }
}

fun rsaEncrypt(str: String, key: String): String {
    val keyBytes = Base64.getDecoder().decode(key.replace("-----BEGIN PUBLIC KEY-----\n", "").replace("\n-----END PUBLIC KEY-----", ""))
    val spec = X509EncodedKeySpec(keyBytes)
    val keyFactory = KeyFactory.getInstance("RSA")
    val publicKey = keyFactory.generatePublic(spec)

    val cipher = Cipher.getInstance("RSA/ECB/NoPadding")
    cipher.init(Cipher.ENCRYPT_MODE, publicKey)
    val encrypted = cipher.doFinal(str.toByteArray(Charsets.UTF_8))

    return encrypted.joinToString("") { "%02x".format(it) }
}

fun weapiEncrypt(data: JsonObject): Map<String, String> {
    val json = json.encodeToString(data)
    val random = Random()
    val secretKey = buildString {
        for (i in 0 until 16) {
            append(base62[random.nextInt(62)])
        }
    }
    return mapOf(
        "params" to aesEncrypt(
            aesEncrypt(json, "CBC", presetKey, iv),
            "CBC",
            secretKey,
            iv
        ),
        "encSecKey" to rsaEncrypt(secretKey.reversed(), publicKey)
    )
}

fun eapiEncrypt(url: String, data: JsonObject): String {
    val text = json.encodeToString(data)
    val message = "nobody${url}use${text}md5forencrypt"
    val digest = message.toMd5()
    val final = "$url-36cd479b6b5-$text-36cd479b6b5-$digest"
    return aesEncrypt(final, "ECB", eapiKey, "", "hex")
}


fun eapiDecrypt(cipher: String): String {
    val cipherInstance = Cipher.getInstance("AES/ECB/PKCS5Padding")
    val secretKey = SecretKeySpec(eapiKey.toByteArray(StandardCharsets.UTF_8), "AES")
    cipherInstance.init(Cipher.DECRYPT_MODE, secretKey)
    val decodedCipher = Base64.getDecoder().decode(cipher)
    val decryptedBytes = cipherInstance.doFinal(decodedCipher)
    return String(decryptedBytes, StandardCharsets.UTF_8)
}