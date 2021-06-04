package com.example.code.network

import retrofit2.http.GET

const val API_KEY = "XysiavmPaRFTpnvnyzgSTodsxKjGALUYVVPbrDZV"

interface NASAAPIInterface {
  @GET("apod?api_key=$API_KEY")
  suspend fun getDailyPhoto(): PhotoResponse
}