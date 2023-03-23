package com.genrikhsalexandr.focusstart_android_testtask.data.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object BinInfoRepository {
    private const val BASE_URL = "https://lookup.binlist.net/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()
    val service: BinService = retrofit.create(BinService::class.java)
}