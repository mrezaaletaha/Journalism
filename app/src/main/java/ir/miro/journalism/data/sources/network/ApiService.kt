package ir.miro.journalism.data.sources.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author mrezaaletaha
 */

interface ApiService {
    @GET("v4/articles/")
    suspend fun allNews(
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0,
    ): Response<NetworkResponse>
}