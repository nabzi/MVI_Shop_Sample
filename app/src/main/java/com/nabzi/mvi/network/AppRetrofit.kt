package com.example.google_map_sample.network

import com.nabzi.mvi.network.FakeInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AppRetrofit(private val baseUrl: String = "https://github.com//") {
    fun getInstance(): Retrofit {
        val client = OkHttpClient.Builder()
        client.addInterceptor(FakeInterceptor())
        return Retrofit.Builder()
            .client(client.build())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
