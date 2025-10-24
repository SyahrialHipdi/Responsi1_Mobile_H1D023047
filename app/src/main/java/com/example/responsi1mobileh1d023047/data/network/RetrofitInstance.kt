package com.example.responsi1mobileh1d023047.data.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://api.football-data.org/"
    private const val API_KEY = "307f0ad44b264729b46bcfc2bf9a0512" // contoh: "123456abcdef..."

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original: Request = chain.request()
            val request: Request = original.newBuilder()
                .header("X-Auth-Token", API_KEY)
                .build()
            chain.proceed(request)
        }
        .build()

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
