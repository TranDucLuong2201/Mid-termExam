package com.android.mid_termexam.todo.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class SecondViewModel : ViewModel() {
    private val _items = MutableStateFlow(List(20) { "Item #$it" })
    val items = _items.asStateFlow()
}