package com.example.mvvmexample

import androidx.lifecycle.LiveData
import com.example.mvvmexample.Roomdb.Quote
import com.example.mvvmexample.Roomdb.QuoteDao

class QuoteRepository(private val dao: QuoteDao) {

    fun getQuotes(): LiveData<List<Quote>> = dao.getQuotes()

    suspend fun addQuote(quote: Quote) = dao.addQuote(quote)
}