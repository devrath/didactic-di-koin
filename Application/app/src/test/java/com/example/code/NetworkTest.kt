package com.example.code

import com.example.code.di.networkModule
import com.example.code.network.NASAAPIInterface
import com.squareup.moshi.Moshi
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import okhttp3.OkHttpClient
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.qualifier.named
import org.koin.test.KoinTest
import org.koin.test.get
import org.koin.test.inject
import retrofit2.Retrofit

class NetworkTest : KoinTest {
  val api: NASAAPIInterface by inject()
  val moshi: Moshi by inject()
  val retrofit: Retrofit by inject()
  val okHttpClient: OkHttpClient by inject()
  val baseUrl: String by lazy { get(named("BASE_URL")) as String }

  @Before
  fun setup() {
    startKoin {
      modules(listOf(networkModule))
    }
  }

  @After
  fun tearDown() {
    stopKoin()
  }

  @Test
  fun `Test Retrofit Created`() {
    assertNotNull(retrofit)
    assert(baseUrl == "https://api.nasa.gov/planetary/")
  }

  @Test
  fun `Test Moshi Created`() {
    assertNotNull(moshi)
  }

  @Test
  fun `Test API Created`() {
    assertNotNull(api)
  }

  @Test
  fun `Test OKHttp`() {
    assertNotNull(okHttpClient)
    assertTrue(okHttpClient.connectTimeoutMillis == 30000)
    assertTrue(okHttpClient.writeTimeoutMillis == 30000)
    assertTrue(okHttpClient.readTimeoutMillis == 30000)
    assertTrue(okHttpClient.interceptors.size == 1)
  }

}