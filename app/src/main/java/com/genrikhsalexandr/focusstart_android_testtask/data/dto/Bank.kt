package com.genrikhsalexandr.focusstart_android_testtask.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Bank (
    val name: String,
    val url: String,
    val phone: String,
    val city: String
)