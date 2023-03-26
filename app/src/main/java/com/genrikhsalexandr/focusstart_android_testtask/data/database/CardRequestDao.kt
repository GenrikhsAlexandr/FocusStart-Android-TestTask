package com.genrikhsalexandr.focusstart_android_testtask.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface CardRequestDao {
    @Query("SELECT * FROM card_request")
    suspend fun getBinInfo(): List<CardRequest>

    @Insert
    suspend fun insertBinInfo(vararg cardRequest: CardRequest)
}