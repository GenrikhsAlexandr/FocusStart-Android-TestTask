package com.genrikhsalexandr.focusstart_android_testtask.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class BinDto(
    val number: com.genrikhsalexandr.focusstart_android_testtask.data.dto.NumberDto,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val country: CountryDto,
    val bank: BankDto,
)
