package com.example.mvvmexample.Roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun getQuoteDao(): QuoteDao

    companion object {

        @Volatile
        private var instance: QuoteDatabase? = null
        fun getDbInstance(context: Context): QuoteDatabase {
            synchronized(this) {
                if (instance == null)
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        QuoteDatabase::class.java,
                        "QuoteDatabase"
                    ).createFromAsset("quotes.db").build()
            }
            return instance!!
        }
    }
}