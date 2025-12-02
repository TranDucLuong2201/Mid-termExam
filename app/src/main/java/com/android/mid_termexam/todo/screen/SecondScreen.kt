package com.android.mid_termexam.todo.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.mid_termexam.todo.model.Todo
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import com.android.mid_termexam.todo.viewmodel.SecondViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(
    viewModel: SecondViewModel = viewModel(),
    modifier: Modifier = Modifier,
    onOpenDetail: (Todo) -> Unit = { }
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Home / Todos") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.addTodo("New todo ${System.currentTimeMillis() % 1000}") }) {
                Text("+")
            }
        }
    ) { padding ->
        Column(modifier = modifier
            .padding(padding)
            .fillMaxSize()
        ) {
            if (viewModel.uiState == SecondViewModel.UiState.Loading) {
                Text("Loading...", modifier = Modifier.padding(16.dp))
            }
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = Modifier.padding(12.dp) as PaddingValues,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(viewModel.todos, key = { it.id }) { todo ->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Row(modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(modifier = Modifier
                                .clickable { onOpenDetail(todo) }
                            ) {
                                Checkbox(
                                    checked = todo.done,
                                    onCheckedChange = { viewModel.toggleDone(todo.id) }
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(todo.title)
                                    if (todo.description.isNotBlank()) Text(todo.description, modifier = Modifier.padding(top = 4.dp))
                                }
                            }
                            IconButton(onClick = { viewModel.removeTodo(todo.id) }) {
                                Icon(Icons.Default.Delete, contentDescription = "Delete")
                            }
                        }
                    }
                }
            }
        }
    }
}
