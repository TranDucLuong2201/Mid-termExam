// File: app/src/main/java/com/android/mid_termexam/todo/screen/FirstViewModel.kt
package com.android.mid_termexam.todo.viewmodel

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class FirstViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    var email by mutableStateOf(savedStateHandle.get<String>("email") ?: "")
        private set
    var password by mutableStateOf(savedStateHandle.get<String>("password") ?: "")
        private set

    fun onEmailChange(v: String) {
        email = v
        savedStateHandle["email"] = v
    }

    fun onPasswordChange(v: String) {
        password = v
        savedStateHandle["password"] = v
    }

    fun isEmailValid(): Boolean = email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    fun isPasswordValid(): Boolean = password.length >= 6

    fun canSubmit(): Boolean = isEmailValid() && isPasswordValid()

    // Simple placeholder actions: return true when validation passes
    fun login(): Boolean = canSubmit()
    fun register(): Boolean = canSubmit()
}
