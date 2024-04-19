import github.hua0512.ncm.utils.encryption.AESPadding

/**
 * @author hua0512
 * @date : 2024/4/16 19:47
 */
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