package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var txt: TextView
    private lateinit var button: Button
    private val model: MainViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory(20)).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialise()
        

        txt.text = model.getCount().toString()
        button.setOnClickListener{
            setCount()
        }
    }

    fun setCount() {
        model.updateCount()
        txt.text = model.getCount().toString()
    }
    fun initialise() {
        txt = findViewById(R.id.textView)
        button = findViewById(R.id.button)
    }
}