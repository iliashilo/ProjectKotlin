package com.example.projectkotlin.data

import com.example.projectkotlin.data.remote.ImageApiFactory
import com.example.projectkotlin.data.remote.model.ImageApiModel

object ImageRepository {

    private val api = ImageApiFactory.imageApi
    suspend fun getImageFromInet(): ImageApiModel? {
        val response = api.getImage()
        if (response.isSuccessful) {
            if (response.body() != null) {
                val body = response.body()
                return body!!
            }
        }
        return null
    }

}