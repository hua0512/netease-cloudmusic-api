import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.cookies.*
import io.ktor.client.plugins.logging.*
import kotlin.time.DurationUnit
import kotlin.time.toDuration

open class BaseNetworkTest {

    val client = HttpClient {
        install(Logging) {
            level = LogLevel.ALL
            logger = Logger.SIMPLE
        }
        install(HttpRequestRetry) {
            retryOnServerErrors(maxRetries = 5)
            exponentialDelay()
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 5000
            connectTimeoutMillis = 5000
            socketTimeoutMillis = 30.toDuration(DurationUnit.SECONDS).inWholeMilliseconds
        }
        install(HttpCookies) {
            storage = AcceptAllCookiesStorage()
        }
    }

}