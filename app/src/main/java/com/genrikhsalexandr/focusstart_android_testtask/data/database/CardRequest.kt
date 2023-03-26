package com.genrikhsalexandr.focusstart_android_testtask.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_request")
data class CardRequest(
    @PrimaryKey
    val bin: Int,
)