package com.example.projectkotlin.domain

import com.example.projectkotlin.data.ImageRepository

object ImageUseCase {

    private val remRepository = ImageRepository

    suspend fun getImage(): String{
        val dogImage = remRepository.getImageFromInet()?.message ?: String()
        return dogImage
    }
}