package com.genrikhsalexandr.focusstart_android_testtask.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class BankDto(
    val name: String,
    val url: String,
    val phone: String,
    val city: String,
)