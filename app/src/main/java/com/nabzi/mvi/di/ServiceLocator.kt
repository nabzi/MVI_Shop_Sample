package com.nabzi.mvi.di

import com.example.google_map_sample.network.ApiService
import com.example.google_map_sample.network.AppRetrofit
import com.nabzi.mvi.R
import com.nabzi.mvi.data.ProductRepository
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import java.net.HttpURLConnection

//Didn't have enough time to integrate koin dependency injection with Mvrx
object ServiceLocator {
    fun getApiService() : ApiService{
        return AppRetrofit().getInstance().create(ApiService::class.java)
    }
    fun getProductRepository() : ProductRepository{
        return ProductRepository(getApiService())
    }

}