package com.gincana.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gincana.model.User

class LobbyViewModel():ViewModel() {

    private val members = MutableLiveData(listOf(""))
    //TODO: live data list of
}