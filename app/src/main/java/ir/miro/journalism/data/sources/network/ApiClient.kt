package ir.miro.journalism.data.sources.network

import ir.miro.journalism.NetworkResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * @author mrezaaletaha
 */

object ApiClient {
    private const val BASE_URL = ""


    fun build(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java) as ApiService
    }

    interface ApiService {
        @GET("/v4/articles/")
        suspend fun allNews(): Response<NetworkResponse>
    }
}