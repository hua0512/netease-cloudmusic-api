package github.hua0512.ncm.utils.encryption

import dev.whyoleg.cryptography.CryptographyProvider
import dev.whyoleg.cryptography.DelicateCryptographyApi
import dev.whyoleg.cryptography.algorithms.symmetric.AES
import io.ktor.utils.io.core.*

sealed class AESMode(val mode: String) {
  data object CBC : AESMode("CBC")
  data object ECB : AESMode("ECB")
}

sealed class AESPadding(val mode: String) {
  data object PKCS5Padding : AESPadding("PKCS5Padding")
  data object NoPadding : AESPadding("NoPadding")
}

/**
 * @author hua0512
 * @date : 2024/4/15 22:32
 */

@OptIn(DelicateCryptographyApi::class)
suspend fun aesEncrypt(data: String, mode: AESMode, paddingMode: AESPadding, key: String, iv: String?): ByteArray {
  return when (mode) {
    is AESMode.CBC -> {
      require(iv != null) { "iv must not be null in CBC mode" }
      // use multiplatform implementation
      CryptographyProvider.Default
        .get(AES.CBC)
        .keyDecoder()
        .decodeFrom(AES.Key.Format.RAW, key.toByteArray())
        .cipher(paddingMode == AESPadding.PKCS5Padding)
        .encrypt(iv.toByteArray(), data.toByteArray())
    }

    is AESMode.ECB -> {
      throw NotImplementedError("AES ECB mode is not supported")
    }
  }
}