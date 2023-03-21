package com.genrikhsalexandr.focusstart_android_testtask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.genrikhsalexandr.focusstart_android_testtask.databinding.ActivityBinBinding

class BinActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBinBinding


    override fun onCreate(savedInstanceState: Bundle?) {
      binding = ActivityBinBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}