package com.android.mid_termexam.todo.viewmodel

import androidx.lifecycle.ViewModel
import com.android.mid_termexam.todo.model.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.collections.listOf

class CakeMenuViewModel: ViewModel() {
        private val _items = MutableStateFlow(listOf(
            OrderUiState(name = "Choco"),
            OrderUiState(name = "Strawbery"),
            OrderUiState("Cheese"),
            OrderUiState(name = "Matcha"),
            OrderUiState("Sugar"),
            ))
        val items = _items.asStateFlow()
}