package com.android.mid_termexam.todo.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.mid_termexam.todo.viewmodel.FirstViewModel

/**
 * XEM PHẦN Example của mỗi phần để lấy hướng dẫn cụ thể
 */
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FirstScreen(
    modifier: Modifier,
    onClick: () -> Unit = { },
    onBackClick: () -> Unit = { },
    viewModel: FirstViewModel = viewModel()
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Todo List") }
            )
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center, // Sắp xếp theo chiều dọc, từ trên xuống dưới
            horizontalAlignment = Alignment.CenterHorizontally // Căn giữa theo chiều ngang
        ) {
            // Các thành phần sẽ được xếp từ trên xuống dưới, giữa theo chiều ngang
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Order Cupcake",
                fontSize = 12.sp,
                maxLines = 1
            )
        }
    }
}

@Composable
@Preview
fun FirstScreenPreview() {
    FirstScreen(modifier = Modifier)
}
