package com.genrikhsalexandr.focusstart_android_testtask.data

import androidx.room.Room
import com.genrikhsalexandr.focusstart_android_testtask.data.api.BinService
import com.genrikhsalexandr.focusstart_android_testtask.data.database.AppDatabase
import com.genrikhsalexandr.focusstart_android_testtask.data.database.ApplicationContext
import com.genrikhsalexandr.focusstart_android_testtask.data.database.CardRequest
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


object BinInfoRepository {
    private const val BASE_URL = "https://lookup.binlist.net/"

    private val json = Json { ignoreUnknownKeys = true }

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .client(
            OkHttpClient.Builder()
                .apply {
                    addInterceptor(
                        HttpLoggingInterceptor().setLevel(
                            HttpLoggingInterceptor
                                .Level.BODY
                        )
                    )
                }
                .build()
        )
        .build()

    private val service: BinService = retrofit.create(BinService::class.java)

    private val db = Room.databaseBuilder(
        ApplicationContext.appContext!!,
        AppDatabase::class.java, "database-name"
    ).build()

    suspend fun getCardInfo(bin: Int) = service.getBinInfo(bin)

    suspend fun saveCardRequest(bin: Int) {
        db.cardRequestDao().insertBinInfo(CardRequest(bin))
    }

    suspend fun getCardRequest(): List<CardRequest> {
        val userDao = db.cardRequestDao()
        return userDao.getBinInfo()
    }
}


