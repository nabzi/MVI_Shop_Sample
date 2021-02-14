package com.example.google_map_sample.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class AppRetrofit(private val baseUrl: String = "https://dindinn.com/") {
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .client(OkHttpClient.Builder().build())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}