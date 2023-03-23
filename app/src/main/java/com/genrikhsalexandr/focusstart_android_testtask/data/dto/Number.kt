package com.genrikhsalexandr.focusstart_android_testtask.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Number(
    val length: Long,
    val luhn: Boolean,
)