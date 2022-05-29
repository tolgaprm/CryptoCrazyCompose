package com.prmto.cryptocrazycompose.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.prmto.cryptocrazycompose.repo.CryptoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    val repository: CryptoRepository
):ViewModel() {

    private val _ = mutableStateOf<>()
    val : State<> get() = _ 

}