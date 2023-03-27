package com.genrikhsalexandr.focusstart_android_testtask.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.genrikhsalexandr.focusstart_android_testtask.R
import com.genrikhsalexandr.focusstart_android_testtask.databinding.FragmentCardInfoBinding
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class CardInfoFragment : Fragment() {

    companion object {
        fun newInstance(): CardInfoFragment {
            return CardInfoFragment()
        }
    }

    private val viewModel: BinViewModel by activityViewModels()
    private var _binding: FragmentCardInfoBinding? = null
    private val binding: FragmentCardInfoBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCardInfoBinding.inflate(inflater, container, false)
        lifecycleScope.launch {
            viewModel.cardInfo.filterNotNull().collect {
                with(binding) {
                    tvNetName.text = it.scheme
                    tvBrandName.text = it.brand
                    tvLengthName.text = it.number.length.toString()
                    tvLuhnName.text =
                        (if (it.number.luhn) resources.getString(R.string.Yes)
                        else resources.getString(R.string.No)).toString()
                    tvTypeName.text = it.type
                    tvPrepaidName.text =
                        (if (it.prepaid) resources.getString(R.string.Yes)
                        else resources.getString(R.string.No)).toString()
                    tvCountryEmoji.text = it.country.emoji
                    tvCountryName.text = it.country.name
                    tvBankName.text = it.bank.name
                    tvSite.text = it.bank.url
                    tvPhone.text = it.bank.phone
                }
            }
        }

        binding.tvSite.setOnClickListener {
            try {
                val url = "${viewModel.cardInfo.value?.bank?.url}"
                openWebPage(url)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return binding.root
    }

    private fun openWebPage(url: String) {
        var webpage: Uri = Uri.parse(url)
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            webpage = Uri.parse("http://$url");
        }
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}