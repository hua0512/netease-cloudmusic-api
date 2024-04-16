package github.hua0512.ncm.apis.search

import github.hua0512.ncm.apis.base.INeteaseApi
import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.FailedResponse
import github.hua0512.ncm.data.search.NeteaseSearchResponse
import github.hua0512.ncm.data.search.NeteaseSearchType

/**
 * @author hua0512
 * @date : 2024/4/12 14:14
 */
interface ISearch : INeteaseApi {

    suspend fun search(
        keywords: String,
        limit: Int? = 30,
        offset: Int? = 0,
        type: NeteaseSearchType? = NeteaseSearchType.TRACK
    ): NetworkResponse<NeteaseSearchResponse, FailedResponse>
}