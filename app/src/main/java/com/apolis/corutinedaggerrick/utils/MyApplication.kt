package com.apolis.corutinedaggerrick.utils

import android.app.Application
import android.content.Context
import android.util.Log
import com.apolis.corutinedaggerrick.app.di.AppComponent
import com.apolis.corutinedaggerrick.app.di.DaggerAppComponent

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.create()

    }

    companion object{
        private lateinit var instance: MyApplication
        lateinit var appComponent: AppComponent

        fun getAppContext(): Context {
            Log.d("abc","getContext")
            return instance.applicationContext
        }

        fun getInstance(): MyApplication{
            return instance
        }
    }
}