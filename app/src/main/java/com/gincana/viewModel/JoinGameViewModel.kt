package com.gincana.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JoinGameViewModel(): ViewModel() {
    private val isLoading = MutableLiveData(false)
    private val hasErrors = MutableLiveData(false)
    private val gameCode = MutableLiveData("")
    fun gameCode(): LiveData<String> = gameCode
    fun isLoading(): LiveData<Boolean> = isLoading
    fun hasErrors(): LiveData<Boolean> = hasErrors

    fun checkGameCode(){
        val setCode = 1234


    }
}