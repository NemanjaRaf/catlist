package com.nemanja02.catlist

import com.nemanja02.catlist.model.Breed
import com.nemanja02.catlist.model.Image
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface CatApiService {
    @GET("v1/breeds")
    suspend fun getBreeds(): List<Breed>

    @GET("v1/breeds/{breedId}")
    suspend fun getBreedDetails(@Path("breedId") breedId: String): Breed

    @GET("v1/images/search")
    suspend fun getBreedImages(@Query("breed_ids") breedId: String): List<Image>
}

object RetrofitInstance {
    private const val BASE_URL = "https://api.thecatapi.com/"

    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("x-api-key", "live_vhKOYfTijo6jyD28YPXzjTJOrNg3M6ipPdWXuUnyB1Pg9fKFwVEtrC3TydPZaKwH")
                .build()
            chain.proceed(request)
        }
        .build()

    val api: CatApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CatApiService::class.java)
}
