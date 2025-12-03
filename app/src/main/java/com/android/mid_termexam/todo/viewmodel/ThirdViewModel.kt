// File: app/src/main/java/com/android/mid_termexam/todo/screen/ThirdViewModel.kt
package com.android.mid_termexam.todo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class ThirdViewModel : ViewModel() {

    private val _slider = MutableStateFlow(0f)
    val slider = _slider.asStateFlow()

    private val _selected = MutableStateFlow("A")
    val selected = _selected.asStateFlow()

    private val _expanded = MutableStateFlow(false)
    val expanded = _expanded.asStateFlow()

    fun setSlider(v: Float) { _slider.value = v }
    fun setSelected(v: String) { _selected.value = v }
    fun setExpanded(v: Boolean) { _expanded.value = v }
}