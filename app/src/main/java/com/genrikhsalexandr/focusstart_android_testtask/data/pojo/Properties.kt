package com.genrikhsalexandr.focusstart_android_testtask.data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Properties(
    @SerializedName("foo")
    @Expose
    val foo: Foo? = null,
    @SerializedName("bar")
    @Expose
    val bar: Bar? = null,
    @SerializedName("baz")
    @Expose
    val baz: Baz? = null,
)
