package com.genrikhsalexandr.focusstart_android_testtask.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CountryDto(
    val name: String,
    val emoji: String,
)