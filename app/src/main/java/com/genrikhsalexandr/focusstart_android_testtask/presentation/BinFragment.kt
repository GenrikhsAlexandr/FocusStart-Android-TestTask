package com.genrikhsalexandr.focusstart_android_testtask.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.genrikhsalexandr.focusstart_android_testtask.R
import com.genrikhsalexandr.focusstart_android_testtask.data.api.BinService
import com.genrikhsalexandr.focusstart_android_testtask.databinding.FragmentBinBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class BinFragment : Fragment() {

    companion object {
        fun newInstance() = BinFragment()
    }

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
            viewModel.request.collect{ it ->
                binding.requestHistory.text = it.joinToString { it.toString() + "\n" }
            }
        }
        return binding.root
    }

override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
}
}