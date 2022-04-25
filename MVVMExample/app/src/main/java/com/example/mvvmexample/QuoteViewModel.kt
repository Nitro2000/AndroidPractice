package com.example.mvvmexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmexample.Roomdb.Quote
import kotlinx.coroutines.launch

class QuoteViewModel(val repository: QuoteRepository): ViewModel() {

    fun getQuotes() = repository.getQuotes()

    fun addQuote(quote: Quote) {
        viewModelScope.launch {
            repository.addQuote(quote)
        }
    }
}