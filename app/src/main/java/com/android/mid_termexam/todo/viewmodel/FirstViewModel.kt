// File: app/src/main/java/com/android/mid_termexam/todo/screen/FirstViewModel.kt
package com.android.mid_termexam.todo.viewmodel


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class FirstViewModel : ViewModel() {
    private val _text = MutableStateFlow("")
    val text = _text.asStateFlow()

    private val _checked = MutableStateFlow(false)
    val checked = _checked.asStateFlow()

    private val _switchOn = MutableStateFlow(false)
    val switchOn = _switchOn.asStateFlow()

    fun setText(t: String) { _text.value = t }
    fun toggleCheck(b: Boolean) { _checked.value = b }
    fun toggleSwitch(b: Boolean) { _switchOn.value = b }
}