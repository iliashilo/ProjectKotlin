package com.example.projectkotlin.presentation.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectkotlin.domain.ImageUseCase
import kotlinx.coroutines.launch

class SecondImagesViewModel : ViewModel() {
    private val useCase = ImageUseCase
    val image = MutableLiveData<String>()

    fun getImage() {

        viewModelScope.launch {
            image.postValue(useCase.getImage())
        }
    }
}