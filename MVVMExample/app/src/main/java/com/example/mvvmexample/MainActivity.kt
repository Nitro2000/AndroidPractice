package com.example.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmexample.Roomdb.Quote
import com.example.mvvmexample.Roomdb.QuoteDatabase
import com.example.mvvmexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var quoteDb: QuoteDatabase
    private lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        quoteDb = QuoteDatabase.getDbInstance(this)
        quoteViewModel = ViewModelProvider(
            this,
            QuoteViewModelFactory(QuoteRepository(quoteDb.getQuoteDao()))
        ).get(QuoteViewModel::class.java)

        quoteViewModel.getQuotes().observe(this, Observer {
            binding.quote = it.toString()
        })


    }
    fun addQuote(view: View) {
        quoteViewModel.addQuote(Quote(0, "Work like hell", "Elon musk"))
    }
}