package com.example.roomdatabase.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val phoneNum: String,
    val isActive: Int
    )