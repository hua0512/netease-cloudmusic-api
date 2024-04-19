package github.hua0512.ncm.utils

import github.hua0512.ncm.utils.encryption.AESPadding

internal actual object Crypto {
  actual fun aesECBEncrypt(text: String, key: String, paddingMode: AESPadding): ByteArray {
    TODO("Not yet implemented")
  }

  actual fun aesECBDencrypt(
    text: String,
    key: String,
    paddingMode: AESPadding,
  ): ByteArray {
    TODO("Not yet implemented")
  }

  actual fun rsaEncrypt(str: String, key: ByteArray): ByteArray {
    TODO("Not yet implemented")
  }

}