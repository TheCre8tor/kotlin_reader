package com.example.kotlinreader.screens.login

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginScreenViewModel : ViewModel() {
    // val loadingState = MutableStateFlow(LoadingState.IDLE)
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading


    fun signIn(context: Context, email: String, password: String, home: () -> Unit) =
        viewModelScope.launch {
            try {
                _loading.value = true


                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            home()
                        } else {
                            Log.d("FIREBASE - FAILED", "signIn: ${task.result}")
                        }
                        _loading.value = false
                    }.addOnFailureListener { error ->
                        toast(context, message = error.message)
                        println("ERROR: ${error.message}")

                    }
            } catch (error: Exception) {
                toast(context, message = error.message)
            }
        }

    private fun toast(context: Context, message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun addUserToFirestore(task: Task<AuthResult>) {
        val displayName = task.result.user?.email?.split('@')?.get(0)
        val userId = auth.currentUser?.uid
        val user = mutableMapOf<String, Any>()

        user["user_id"] = "$userId"
        user["name"] = "$displayName"

        val firestore = FirebaseFirestore.getInstance()
        val usersTable = firestore.collection("users")
        usersTable.add(user)
    }

    fun createUser(email: String, password: String, callback: () -> Unit) {
        if (_loading.value == false) {
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        addUserToFirestore(task)
                        callback()
                    } else {
                        Log.d("FIREBASE - FAILED", "signIn: ${task.result}")
                    }
                    _loading.value = false
                }
        }
    }

}

