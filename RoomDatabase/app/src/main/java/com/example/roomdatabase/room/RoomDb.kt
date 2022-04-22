package com.example.roomdatabase.room

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class RoomDb : RoomDatabase() {

    abstract fun getDao(): ContactDao

    companion object {
        @Volatile
        private var roomInstance: RoomDb? = null

        fun getInstance(context: Context): RoomDb {
            if (roomInstance == null) {
                /* It is possible that two or more thread try to instantiate db at same time.
                 so there is possibility of making several instance so to stop we use "locking" by synchronised fun */
                synchronized(this) {
                    roomInstance =
                        Room.databaseBuilder(
                            context.applicationContext,
                            RoomDb::class.java,
                            "MyContactDb"
                        ).build()
                }
            }
            return roomInstance!!
        }
    }
}