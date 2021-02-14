package com.nabzi.mvi.di

import com.example.google_map_sample.network.ApiService
import com.example.google_map_sample.network.AppRetrofit
import com.nabzi.mvi.data.ProductRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val AppModules = module {
    single<ProductRepository>{ ProductRepository(get())}
    // mock server address is passed for base url
    single{ AppRetrofit("/").getInstance().create(ApiService::class.java)}
}