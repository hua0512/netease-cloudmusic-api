package github.hua0512.ncm.apis.country

import github.hua0512.ncm.apis.base.BaseNeteaseNetworkImpl
import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.RequestMode
import github.hua0512.ncm.data.location.NeteaseCountryResponse
import io.ktor.client.*

class CountryImpl(client: HttpClient) : BaseNeteaseNetworkImpl(client), ICountry {

    override suspend fun getCountriesCode(): NetworkResponse<NeteaseCountryResponse, FailedResponse> =
        postApi(baseUrl = INTERFACE_BASE_URL, pathName = "/api/lbs/countries/v1", mode = RequestMode.EAPI)
}