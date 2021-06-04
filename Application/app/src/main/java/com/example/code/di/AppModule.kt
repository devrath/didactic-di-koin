package com.example.code.di

import com.example.code.DefaultCurrentActivityListener
import com.example.code.utils.contexthelper.ActivityRetriever
import org.koin.dsl.module

val appModule = module {
    single { DefaultCurrentActivityListener() }
    single { ActivityRetriever(get()) }
}