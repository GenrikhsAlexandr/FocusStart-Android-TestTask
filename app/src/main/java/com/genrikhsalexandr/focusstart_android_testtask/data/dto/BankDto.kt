package com.genrikhsalexandr.focusstart_android_testtask.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class BankDto(
    val name: String? = null,
    val url: String? = null,
    val phone: String? = null,
    val city: String? = null,
)