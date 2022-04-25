package com.example.listadapteranddiffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val item1 = PersonModel(1, "Rishabh", "R")
        val item2 = PersonModel(2, "Nitro", "N")
        val item3 = PersonModel(3, "Apex", "A")

        val personList = mutableListOf(item1, item2, item3)

        val recyView = findViewById<RecyclerView>(R.id.personRecView)
        val perAdapter = PersonAdapter()
        perAdapter.submitList(personList)
        recyView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = perAdapter
        }

        Handler(Looper.getMainLooper()).postDelayed({
            val list = listOf(PersonModel(2, "Nitro", "N"))
            Log.d("tage", personList.toString())
            perAdapter.submitList(list)
        }, 4000)
    }
}