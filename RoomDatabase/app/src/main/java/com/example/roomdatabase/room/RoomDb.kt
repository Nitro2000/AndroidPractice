package com.example.roomdatabase.room

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class], version = 2)
abstract class RoomDb : RoomDatabase() {

    abstract fun getDao(): ContactDao

    companion object {

        val migrate_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Contact ADD isActive INTEGER DEFAULT 1")
            }

        }

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
                        ).addMigrations(migrate_1_2).build()
                }
            }
            return roomInstance!!
        }
    }
}