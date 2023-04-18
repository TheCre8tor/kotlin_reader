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

class LoginScreenViewModel : ViewModel() {
    // val loadingState = MutableStateFlow(LoadingState.IDLE)
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    fun signIn(email: String, password: String, home: () -> Unit) = viewModelScope.launch {
        try {
            _loading.value = true

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("FIREBASE - OK", "signIn: ${task.result}")
                        home()
                    } else {
                        Log.d("FIREBASE - FAILED", "signIn: ${task.result}")
                    }
                    _loading.value = false
                }
        } catch (error: Exception) {
            Log.d("FIREBASE - ERROR", "signIn: ${error.message}")
        }
    }

    fun createUser(email: String, password: String, callback: () -> Unit) {
        if (_loading.value == false) {
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("FIREBASE - REGISTERED", "signIn: ${task.result}")
                        callback()
                    } else {
                        Log.d("FIREBASE - FAILED", "signIn: ${task.result}")
                    }
                    _loading.value = false
                }
        }
    }

}

