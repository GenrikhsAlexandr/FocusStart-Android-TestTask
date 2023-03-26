package com.genrikhsalexandr.focusstart_android_testtask.data.database

import android.app.Application
import android.content.Context

class ApplicationContext : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

     companion object {
        private var context: Context? = null
         val appContext:Context?
         get() = context
    }


}
