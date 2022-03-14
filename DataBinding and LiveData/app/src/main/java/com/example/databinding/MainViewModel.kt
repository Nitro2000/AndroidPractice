package com.example.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val mutText = MutableLiveData<String>("Hello moto")

    val text: LiveData<String>
    get() = mutText

    fun update() {
        mutText.value = "Hi Moto"
    }
}