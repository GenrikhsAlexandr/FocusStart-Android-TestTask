package com.genrikhsalexandr.focusstart_android_testtask.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface CardRequestDao {
    @Query("SELECT * FROM card_request")
    suspend fun getListCardRequest(): List<CardRequest>

    @Insert
    suspend fun insertBinInfo(vararg cardRequest: CardRequest)
}