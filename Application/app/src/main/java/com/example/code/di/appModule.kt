package com.example.code.di

import com.example.code.ActivityRetriever
import com.example.code.DefaultCurrentActivityListener
import org.koin.dsl.module

val appModule = module {
    single { DefaultCurrentActivityListener() }
    single { ActivityRetriever(get()) }
}