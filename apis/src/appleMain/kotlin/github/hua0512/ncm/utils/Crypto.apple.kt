@file:OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)

package github.hua0512.ncm.utils

import github.hua0512.ncm.utils.encryption.AESPadding
import kotlinx.cinterop.*
import platform.CoreCrypto.*
import platform.CoreFoundation.*
import platform.Foundation.*
import platform.Security.*
import platform.posix.memcpy
import platform.posix.size_t

/**
 * @author hua0512
 * @date : 2024/4/16 19:47
 */
internal actual object Crypto {

  private fun aesECBCrypt(data: ByteArray, key: ByteArray, paddingMode: AESPadding, operation: CCOperation): ByteArray {
    val padding: UInt = when (paddingMode) {
      AESPadding.PKCS5Padding -> kCCOptionPKCS7Padding
      AESPadding.NoPadding -> 0u
    }

    val keyBytes = key.usePinned { it.addressOf(0) }
    val dataBytes = data.usePinned { it.addressOf(0) }
    val bufferSize = data.size + kCCBlockSizeAES128.toInt()
    val buffer = ByteArray(bufferSize)
    val bufferBytes = buffer.usePinned { it.addressOf(0) }
    val numBytesProcessed = nativeHeap.alloc<ULongVar>()

    val cryptStatus = CCCrypt(
      operation,
      kCCAlgorithmAES,
      kCCOptionECBMode or padding,
      keyBytes,
      kCCKeySizeAES128.convert<size_t>(),
      null,
      dataBytes,
      data.size.convert<size_t>(),
      bufferBytes,
      bufferSize.convert<size_t>(),
      numBytesProcessed.ptr
    )

    if (cryptStatus != kCCSuccess) {
      throw IllegalStateException("${if (operation == kCCEncrypt) "Encryption" else "Decryption"} failed with status: $cryptStatus")
    }

    return buffer.copyOf(numBytesProcessed.value.toInt())
  }

  actual fun aesECBEncrypt(text: String, key: String, paddingMode: AESPadding): ByteArray {
    val data = text.encodeToByteArray()
    val keyData = key.encodeToByteArray()
    return aesECBCrypt(data, keyData, paddingMode, kCCEncrypt)
  }

  actual fun aesECBDecrypt(text: String, key: String, paddingMode: AESPadding): ByteArray {
    val dataBytes = text.decodeBase64()
    val keyData = key.encodeToByteArray()
    return aesECBCrypt(dataBytes, keyData, paddingMode, kCCDecrypt)
  }

  actual fun rsaEncrypt(str: String, key: ByteArray): ByteArray {
    // TODO: Implement RSA encryption
    return ByteArray(0)
  }
}

// Extension function to decode Base64 string to ByteArray
fun String.decodeBase64(): ByteArray = NSData.create(base64EncodedString = this, options = 0u)!!.toByteArray()

// Extension function to convert NSData to ByteArray
fun NSData.toByteArray(): ByteArray {
  val bytes = ByteArray(this.length.toInt())
  bytes.usePinned {
    memcpy(it.addressOf(0), this.bytes, this.length)
  }
  return bytes
}
