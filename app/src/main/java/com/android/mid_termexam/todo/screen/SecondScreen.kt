package com.android.mid_termexam.todo.screen


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.mid_termexam.todo.viewmodel.SecondViewModel

@Composable
fun SecondScreen(
    modifier: Modifier,
    onClick: () -> Unit = { },
    onBackClick: () -> Unit = { },
    viewModel: SecondViewModel = viewModel()
) {

}
