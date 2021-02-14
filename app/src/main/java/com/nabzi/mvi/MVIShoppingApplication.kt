package com.nabzi.mvi

import android.app.Application
import androidx.databinding.DataBindingUtil
import com.airbnb.mvrx.Mavericks
import com.nabzi.mvi.data.ProductRepository
import com.nabzi.mvi.di.AppModules
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.net.HttpURLConnection

class MVIShoppingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
        startKoin {
            // declare used Android context
            androidContext(this@MVIShoppingApplication)
            // declare modules
            modules(AppModules)
        }
        GlobalScope.launch {
            setupMockServer()
        }
    }

    private  suspend fun setupMockServer() {
        val mockWebServer = MockWebServer()
        mockWebServer.start()
        var mockResponseJson = this.getString(R.string.productList)
        val mockResponse = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(mockResponseJson)
        mockWebServer.enqueue(mockResponse)
    }
}