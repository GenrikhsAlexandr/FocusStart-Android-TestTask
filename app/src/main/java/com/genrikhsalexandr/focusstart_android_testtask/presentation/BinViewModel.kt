package com.genrikhsalexandr.focusstart_android_testtask.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genrikhsalexandr.focusstart_android_testtask.data.BinInfoRepository
import com.genrikhsalexandr.focusstart_android_testtask.data.dto.BinDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BinViewModel(
    private val repository: BinInfoRepository = BinInfoRepository
) : ViewModel() {

    val cardInfo: MutableStateFlow<BinDto?> = MutableStateFlow(null)

    val request: MutableStateFlow<List<Int>> = MutableStateFlow(emptyList())
    fun getCardInfo(bin: String) {
        if (bin.length >= 6) {
            viewModelScope.launch {
                try {
                    cardInfo.value = repository.getCardInfo(bin.toInt())
                    repository.saveCardRequest(bin.toInt())
                    request.value = repository.getCardRequest().map {
                        it.bin

                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}