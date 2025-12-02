package com.android.mid_termexam.todo.model

data class Todo(
    val id: Int,
    val title: String,
    val description: String = "",
    val done: Boolean = false
) {
}