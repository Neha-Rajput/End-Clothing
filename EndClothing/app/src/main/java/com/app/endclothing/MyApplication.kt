package com.app.endclothing

import androidx.multidex.MultiDexApplication
import com.app.endclothing.di.apiModule
import com.app.endclothing.di.netModule
import com.app.endclothing.di.viewModelScope
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        configureKoin()
    }

    private fun configureKoin() {
        startKoin {
            androidContext(this@MyApplication)
            modules(netModule, apiModule, viewModelScope)
        }
    }
}