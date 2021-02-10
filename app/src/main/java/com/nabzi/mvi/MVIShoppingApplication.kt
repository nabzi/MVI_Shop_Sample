package com.nabzi.mvi

import android.app.Application
import androidx.databinding.DataBindingUtil
import com.airbnb.mvrx.Mavericks

class MVIShoppingApplication : Application() {
    var productRepository = ProductRepository()
    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)

    }
}