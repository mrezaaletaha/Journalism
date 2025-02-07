package ir.miro.journalism.data.sources.network

import retrofit2.Response
import retrofit2.http.GET

/**
 * @author mrezaaletaha
 */

interface ApiService {
    @GET("v4/articles/")
    suspend fun allNews(): Response<NetworkResponse>
}