package github.hua0512.ncm.apis.login.captcha

interface ICaptcha {

  fun getCaptcha(): String

  fun createCaptcha(key: String, qrimg: String?): String

  fun verifyCaptcha(key: String, captcha: String): String
}