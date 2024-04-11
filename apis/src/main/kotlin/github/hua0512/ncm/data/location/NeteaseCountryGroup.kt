package github.hua0512.ncm.data.location

import kotlinx.serialization.Serializable

@Serializable
data class NeteaseCountryGroup(
    val label: String = "",
    val countryList: List<NeteaseCountry> = listOf()
)
