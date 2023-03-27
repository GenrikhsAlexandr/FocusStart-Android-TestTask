package com.genrikhsalexandr.focusstart_android_testtask.data.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [CardRequest::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {



    abstract fun cardRequestDao(): CardRequestDao
}
