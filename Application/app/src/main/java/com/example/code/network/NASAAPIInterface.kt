package com.example.code.network

import retrofit2.http.GET

const val API_KEY = "Sbvm1ly3ZgmeZUeASUaUWG01icWgmnAQI2UyyoXD"

interface NASAAPIInterface {
  @GET("apod?api_key=$API_KEY")
  suspend fun getDailyPhoto(): PhotoResponse
}