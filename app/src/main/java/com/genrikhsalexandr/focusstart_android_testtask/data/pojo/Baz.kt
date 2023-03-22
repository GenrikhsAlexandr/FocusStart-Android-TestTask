package com.genrikhsalexandr.focusstart_android_testtask.data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Baz(
    @SerializedName("type")
    @Expose
    val type: String? = null,
)