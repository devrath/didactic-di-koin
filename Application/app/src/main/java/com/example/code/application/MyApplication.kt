package com.example.code.application

import android.app.Application
import com.example.code.DefaultCurrentActivityListener
import com.example.code.di.appModule
import com.example.code.di.networkModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

  val defaultCurrentActivityListener: DefaultCurrentActivityListener by inject()

  override fun onCreate() {
    super.onCreate()
    startKoin {
      androidLogger()
      androidContext(this@MyApplication)
      modules(listOf(networkModule, appModule))
    }
    registerActivityLifecycleCallbacks(defaultCurrentActivityListener)
  }
}