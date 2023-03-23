package com.genrikhsalexandr.focusstart_android_testtask.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val name: String,
    val emoji: String,
)