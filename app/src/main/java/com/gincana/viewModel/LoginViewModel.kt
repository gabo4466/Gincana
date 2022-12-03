package com.gincana.viewModel

import android.app.Activity
import android.content.Intent
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions


class LoginViewModel: ViewModel() {
    private val isLoading = MutableLiveData(false)
    private val hasErrors = MutableLiveData(false)
    fun isLoading(): LiveData<Boolean> = isLoading
    fun hasErrors(): LiveData<Boolean> = hasErrors

    fun logInWithGoogle(activity: Activity) {
        isLoading.postValue(true)
        val gso: GoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        // Build a GoogleSignInClient with the options specified by gso.
        val client = GoogleSignIn.getClient(activity, gso);
        val signInIntent: Intent = client.getSignInIntent()
        activity.startActivityForResult(signInIntent, 1)
    }

}