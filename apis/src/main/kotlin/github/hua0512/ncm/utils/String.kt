package github.hua0512.ncm.utils

import java.security.MessageDigest
import java.security.SecureRandom
import kotlin.experimental.and

fun generateRandomHex(size: Int = 16): String {
    val random = SecureRandom()
    val bytes = ByteArray(size)
    random.nextBytes(bytes)
    return bytes.joinToString("") { "%02x".format(it and 0xff.toByte()) }
}

fun String.toMd5(): String {
    val digest = MessageDigest.getInstance("MD5").digest(this.toByteArray())
    return digest.joinToString("") { "%02x".format(it) }
}