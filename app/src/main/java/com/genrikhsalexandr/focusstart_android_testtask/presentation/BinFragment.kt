package com.genrikhsalexandr.focusstart_android_testtask.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.genrikhsalexandr.focusstart_android_testtask.databinding.FragmentBinBinding
import kotlinx.coroutines.launch

class BinFragment : Fragment() {

    private val viewModel: BinViewModel by activityViewModels()
    private var _binding: FragmentBinBinding? = null
    private val binding: FragmentBinBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentBinBinding.inflate(inflater, container, false)

        binding.enterButton.setOnClickListener {
            viewModel.getCardInfo(binding.binET.text.toString())
        }

        lifecycleScope.launch {
            viewModel.request.collect { it ->
                _binding?.requestHistory?.text =
                    it.joinToString(separator = "") { it.toString() + "\n" }
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}