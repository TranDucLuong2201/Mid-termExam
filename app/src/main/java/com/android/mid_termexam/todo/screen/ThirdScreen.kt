package com.android.mid_termexam.todo.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.mid_termexam.todo.viewmodel.ThirdViewModel

@Composable
fun ThirdScreen(
    modifier: Modifier,
    onClick: () -> Unit = { },
    onBackClick: () -> Unit = { },
    viewModel: ThirdViewModel = viewModel()
) {
}