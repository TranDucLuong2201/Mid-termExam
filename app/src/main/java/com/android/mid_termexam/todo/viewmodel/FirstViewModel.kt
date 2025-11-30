package com.android.mid_termexam.todo.viewmodel

import androidx.lifecycle.ViewModel
import com.android.mid_termexam.todo.model.ExampleUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * HƯỚNG DẪN TẠO VIEWMODEL
 *
 */
class FirstViewModel : ViewModel() {
    val _Example_uiState = MutableStateFlow(ExampleUiState())
    val uiState = _Example_uiState.asStateFlow()

    fun onEmailChange(newEmail: String) {
        _Example_uiState.update { currentState ->
            currentState.copy(email = newEmail)
        }
    }

    fun onPasswordChange(newPassword: String) {
        _Example_uiState.update { currentState ->
            currentState.copy(password = newPassword)
        }
    }

}