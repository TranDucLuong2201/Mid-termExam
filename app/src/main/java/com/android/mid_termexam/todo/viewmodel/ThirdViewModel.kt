// File: app/src/main/java/com/android/mid_termexam/todo/screen/ThirdViewModel.kt
package com.android.mid_termexam.todo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.android.mid_termexam.todo.model.Todo

class ThirdViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    // keys are simple; values persist via SavedStateHandle across process death/config changes when supported
    private fun keyTitle(id: Int) = "todo_title_$id"
    private fun keyDesc(id: Int) = "todo_desc_$id"

    var title by mutableStateOf("")
        private set
    var description by mutableStateOf("")
        private set

    // initialize once from Todo if not already in SavedStateHandle
    fun initIfNeeded(todo: Todo) {
        val t = savedStateHandle.get<String>(keyTitle(todo.id))
        val d = savedStateHandle.get<String>(keyDesc(todo.id))
        if (t == null) {
            title = todo.title
            savedStateHandle[keyTitle(todo.id)] = title
        } else {
            title = t
        }
        if (d == null) {
            description = todo.description
            savedStateHandle[keyDesc(todo.id)] = description
        } else {
            description = d
        }
    }

    fun onTitleChange(v: String, todoId: Int) {
        title = v
        savedStateHandle[keyTitle(todoId)] = v
    }

    fun onDescriptionChange(v: String, todoId: Int) {
        description = v
        savedStateHandle[keyDesc(todoId)] = v
    }

    fun buildUpdated(todo: Todo): Todo = todo.copy(title = title, description = description)
}
