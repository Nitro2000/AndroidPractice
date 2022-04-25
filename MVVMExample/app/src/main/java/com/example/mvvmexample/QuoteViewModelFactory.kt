package com.example.mvvmexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class QuoteViewModelFactory(private val quoteRepository: QuoteRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuoteViewModel(quoteRepository) as T
    }

}