package com.nabzi.mvi

import android.app.Application
import androidx.databinding.DataBindingUtil
import com.airbnb.mvrx.Mavericks

class MVIShoppingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }
}