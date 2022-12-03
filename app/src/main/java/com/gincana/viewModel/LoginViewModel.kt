package com.gincana.viewModel

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gincana.R
import com.google.android.gms.auth.GoogleAuthUtil
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


class LoginViewModel() : ViewModel() {
    private val isLoading = MutableLiveData(false)
    private val hasErrors = MutableLiveData(false)
    private val logged = MutableLiveData(false)
    fun logged(): LiveData<Boolean> = logged
    fun isLoading(): LiveData<Boolean> = isLoading
    fun hasErrors(): LiveData<Boolean> = hasErrors

    fun logInWithGoogle(activity: Activity) {
        isLoading.postValue(true)
        val gso: GoogleSignInOptions =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(activity.getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        // Build a GoogleSignInClient with the options specified by gso.
        val client = GoogleSignIn.getClient(activity, gso)
        val signInIntent: Intent = client.signInIntent
        activity.startActivityForResult(signInIntent, 1)
    }

    fun finishLogIn(task: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)

            account?.idToken?.let { token ->
                val auth = FirebaseAuth.getInstance()
                val credential = GoogleAuthProvider.getCredential(token, null)
                auth.signInWithCredential(credential)
                    .addOnCompleteListener{
                        if (it.isSuccessful){
                            val user = auth.currentUser
                            Log.d("Login", "${user?.displayName}")
                            logged.postValue(true)
                        }else {
                            hasErrors.postValue(true)
                        }
                        isLoading.postValue(false)
                    }
            }
        } catch (e: ApiException) {
            hasErrors.postValue(true)
            isLoading.postValue(false)
            e.message?.let { Log.d("Login", "error: "+it) }

        }
    }

}