package github.hua0512.ncm.utils.encryption

/**
 * RSA Encryption related
 * @author hua0512
 * @date : 2024/4/16 14:56
 */

/**
 * RSA Encryption Mode
 */
sealed class RsaMode(val mode: String) {
  /**
   * Electronic Codebook Mode
   */
  data object ECB : RsaMode("ECB")

  /**
   * Cipher Block Chaining Mode
   */
  data object CBC : RsaMode("CBC")
}