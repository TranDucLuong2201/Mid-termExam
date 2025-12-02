// File: app/src/main/java/com/android/mid_termexam/todo/screen/ThirdScreen.kt
package com.android.mid_termexam.todo.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.mid_termexam.todo.model.Todo
import com.android.mid_termexam.todo.viewmodel.ThirdViewModel

@Composable
fun ThirdScreen(
    modifier: Modifier = Modifier,
    todo: Todo,
    viewModel: ThirdViewModel = viewModel(),
    onSave: (Todo) -> Unit = { }
) {
    // ensure initial values are set only once
    viewModel.initIfNeeded(todo)

    Surface(modifier = modifier.fillMaxSize().padding(16.dp)) {
        Column {
            OutlinedTextField(
                value = viewModel.title,
                onValueChange = { viewModel.onTitleChange(it, todo.id) },
                label = { Text("Title") },
                modifier = Modifier.fillMaxSize()
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                value = viewModel.description,
                onValueChange = { viewModel.onDescriptionChange(it, todo.id) },
                label = { Text("Description") },
                modifier = Modifier.height(120.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { onSave(viewModel.buildUpdated(todo)) }) {
                Text("Save")
            }
        }
    }
}
