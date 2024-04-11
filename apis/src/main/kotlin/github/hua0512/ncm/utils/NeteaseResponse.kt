package github.hua0512.ncm.utils

import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.RequestMode
import io.ktor.client.statement.*

// TODO: Implement body eapiDecrypt
public suspend inline fun <reified T, reified U> neteaseResponse(
    request: () -> HttpResponse,
    mode: RequestMode = RequestMode.WEAPI
): NetworkResponse<T, U> = try {
    networkResponse<T, U> {
//        if (mode == RequestMode.EAPI){
//            // decrypt body
//            val response = request()
//        }
        request()
    }

} catch (throwable: Throwable) {
    throwable.asNetworkResponse()
}