package com.example.projectkotlin.data.remote

import com.example.projectkotlin.data.remote.model.ImageApiModel
import retrofit2.Response
import retrofit2.http.GET

interface ImageApiInterface {

    @GET("/api/breeds/image/random")
    suspend fun getImage(): Response<ImageApiModel>

}