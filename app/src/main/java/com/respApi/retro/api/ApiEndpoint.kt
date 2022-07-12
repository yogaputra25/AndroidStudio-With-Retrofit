package com.respApi.retro.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("character")
    fun getData(): Call<MainModel>
}