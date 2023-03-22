package com.genrikhsalexandr.focusstart_android_testtask.data.api

import com.genrikhsalexandr.focusstart_android_testtask.data.pojo.Example
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BinService {

    @GET("{}")
    suspend fun getBinInfo(
        @Path("") number: Int): Example


}
