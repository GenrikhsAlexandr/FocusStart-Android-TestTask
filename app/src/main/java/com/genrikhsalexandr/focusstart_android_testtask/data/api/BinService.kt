package com.genrikhsalexandr.focusstart_android_testtask.data.api

import com.genrikhsalexandr.focusstart_android_testtask.data.dto.BinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface BinService {

    @GET("{bin}")
    suspend fun getBinInfo(
        @Path("bin") number: Int
    ): BinDto
}
