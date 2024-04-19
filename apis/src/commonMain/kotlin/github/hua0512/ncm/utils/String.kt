@file:OptIn(ExperimentalStdlibApi::class, DelicateCryptographyApi::class)

package github.hua0512.ncm.utils

import dev.whyoleg.cryptography.CryptographyProvider
import dev.whyoleg.cryptography.DelicateCryptographyApi
import dev.whyoleg.cryptography.algorithms.digest.MD5
import io.ktor.utils.io.core.*
import kotlin.random.Random

fun generateRandomHex(size: Int = 16): String {
  val bytes = ByteArray(size) { Random.nextInt(0, 256).toByte() }
  return bytes.toHexString()
}

suspend fun String.toMd5(format: HexFormat = HexFormat.Default): String {
  val bytes = this.toByteArray()
  return CryptographyProvider.Default.get(MD5).hasher().hash(bytes).toHexString(format)
}