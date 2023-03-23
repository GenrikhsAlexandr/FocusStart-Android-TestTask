package com.genrikhsalexandr.focusstart_android_testtask.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.genrikhsalexandr.focusstart_android_testtask.databinding.FragmentBinBinding

class BinFragment : Fragment() {

    companion object {
        fun newInstance() = BinFragment()
    }

    private val viewModel: BinViewModel by viewModels()
    private var _binding: FragmentBinBinding? = null
    private val binding: FragmentBinBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentBinBinding.inflate(inflater, container, false)
        return binding.root


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

