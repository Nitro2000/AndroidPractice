package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.room.Contact
import com.example.roomdatabase.room.ContactDao
import com.example.roomdatabase.room.RoomDb
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var contactDao: ContactDao
    private lateinit var txt: TextView
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Room.databaseBuilder(applicationContext, RoomDb::class.java, "ContactDb").build()
        contactDao = database.getDao()
        txt = findViewById(R.id.textView)

        GlobalScope.launch {
            contactDao.addContact(Contact(934, "Rishabh", "8959822592"))
        }
    }

    fun getContact(view: View) {
        contactDao.getContacts().observe(this) {
            txt.text = it.toString()
        }
    }
}