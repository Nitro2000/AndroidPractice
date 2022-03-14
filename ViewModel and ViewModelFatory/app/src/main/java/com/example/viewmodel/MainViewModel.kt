package com.example.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel(private val counter: Int): ViewModel() {


    private var count = counter

    fun updateCount() {
        count += 1
    }

    fun getCount() : Int {
        return count
    }


}