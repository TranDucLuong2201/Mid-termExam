package com.android.mid_termexam.todo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.android.mid_termexam.todo.model.Todo

class SecondViewModel : ViewModel() {
    enum class UiState { Idle, Loading, Error }

    var uiState by mutableStateOf(UiState.Idle)
        private set

    private var nextId = 4
    var todos by mutableStateOf(
        listOf(
            Todo(1, "Learn Compose", "Read tutorials", false),
            Todo(2, "Buy groceries", "Milk, Eggs", true),
            Todo(3, "Homework", "Finish midterm app", false)
        )
    )
        private set

    fun addTodo(title: String) {
        uiState = UiState.Loading
        val new = Todo(nextId++, title)
        todos = todos + new
        uiState = UiState.Idle
    }

    fun removeTodo(id: Int) {
        todos = todos.filter { it.id != id }
    }

    fun toggleDone(id: Int) {
        todos = todos.map { if (it.id == id) it.copy(done = !it.done) else it }
    }
}
