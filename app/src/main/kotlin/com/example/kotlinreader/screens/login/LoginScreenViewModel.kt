package com.example.kotlinreader.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginScreenViewModel: ViewModel() {
    // val loadingState = MutableStateFlow(LoadingState.IDLE)
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(true)
    val loading: LiveData<Boolean> = _loading

    fun signIn(email: String, password: String) = viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        TODO("take them home")
                    } else {
                        Log.d("FIREBASE", "signIn: ${task.result}")
                    }
                }
        } catch (error: Exception) {
            Log.d("FIREBASE", "signIn: ${error.message}")
        }
    }

    fun createUser() {}

}

