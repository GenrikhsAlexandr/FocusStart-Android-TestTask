package com.genrikhsalexandr.focusstart_android_testtask.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BinInfoRepository {
    private const val BASE_URL = "https://lookup.binlist.net/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val service:BinService = retrofit.create(BinService::class.java)

}