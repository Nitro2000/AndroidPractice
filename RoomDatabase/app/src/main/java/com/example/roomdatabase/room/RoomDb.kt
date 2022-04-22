package com.example.roomdatabase.room

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class RoomDb: RoomDatabase() {

    abstract fun getDao() : ContactDao
}