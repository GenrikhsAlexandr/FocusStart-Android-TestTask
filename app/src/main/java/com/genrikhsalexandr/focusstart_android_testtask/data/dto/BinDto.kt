package com.genrikhsalexandr.focusstart_android_testtask.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class BinDto(
    val number: Number,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val country: Country,
    val bank: Bank,
)
