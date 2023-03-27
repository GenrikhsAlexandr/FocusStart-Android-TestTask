package com.genrikhsalexandr.focusstart_android_testtask.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.genrikhsalexandr.focusstart_android_testtask.R
import com.genrikhsalexandr.focusstart_android_testtask.databinding.ActivityBinBinding
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class BinActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBinBinding
    private val viewModel: BinViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            viewModel.cardInfo.filterNotNull().collect {
                replaceFragment(CardInfoFragment.newInstance())
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.bin_container, fragment)
            addToBackStack("BinFragment")
        }
    }
}