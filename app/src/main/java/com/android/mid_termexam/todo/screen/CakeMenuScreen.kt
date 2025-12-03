package com.android.mid_termexam.todo.screen


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.mid_termexam.todo.viewmodel.CakeMenuViewModel


@Composable
fun CakeMenuScreen(
    onNext: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CakeMenuViewModel = viewModel()
) {
    val list = viewModel.items
    LazyColumn(Modifier) {
        items(list.value) { item ->
            Row(modifier = modifier.fillMaxWidth()) {
                Icon(imageVector = Icons.Default.Image, contentDescription = null)
                Text(item.name)
            }
        }
    }
}
