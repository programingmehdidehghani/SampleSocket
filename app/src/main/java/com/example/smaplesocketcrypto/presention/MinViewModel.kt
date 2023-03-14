package com.example.smaplesocketcrypto.presention

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MinViewModel  @Inject constructor (
    private val cryptoRepository: CryptoRepository
) : ViewModel() {

    init {
        getConnect()
    }

    fun getConnect() {
        cryptoRepository.connect()
    }
}