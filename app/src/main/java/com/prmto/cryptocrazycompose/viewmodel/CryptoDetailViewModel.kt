package com.prmto.cryptocrazycompose.viewmodel

import androidx.lifecycle.ViewModel
import com.prmto.cryptocrazycompose.model.Crypto
import com.prmto.cryptocrazycompose.repo.CryptoRepository
import com.prmto.cryptocrazycompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel() {

    suspend fun getCrypto(id: String): Resource<Crypto> {
        return repository.getCrypto(id)
    }
}