package com.genrikhsalexandr.focusstart_android_testtask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.genrikhsalexandr.focusstart_android_testtask.R
import com.genrikhsalexandr.focusstart_android_testtask.databinding.ActivityBinBinding

class BinActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBinBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(BinListInfoFragment())
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.list_info_container, fragment)
        }
    }
}