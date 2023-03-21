package com.genrikhsalexandr.focusstart_android_testtask.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.genrikhsalexandr.focusstart_android_testtask.databinding.FragmentBinListInfoBinding

class BinListInfoFragment : Fragment() {

    companion object {
        fun newInstance() = BinListInfoFragment()
    }

    private val viewModel: BinListInfoViewModel by viewModels()
    private var _binding: FragmentBinListInfoBinding? = null
    private val binding: FragmentBinListInfoBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentBinListInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

}