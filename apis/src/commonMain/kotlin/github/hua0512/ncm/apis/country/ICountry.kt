package github.hua0512.ncm.apis.country

import github.hua0512.ncm.apis.base.INeteaseApi
import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.location.NeteaseCountryResponse

interface ICountry : INeteaseApi {

  suspend fun getCountriesCode(): NetworkResponse<NeteaseCountryResponse, FailedResponse>
}