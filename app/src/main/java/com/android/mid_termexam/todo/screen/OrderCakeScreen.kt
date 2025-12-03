package com.android.mid_termexam.todo.screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.mid_termexam.todo.viewmodel.OrderCakeViewModel

@Composable
fun OrderCakeScreen(
    viewModel: OrderCakeViewModel = viewModel(),
    onBack: () -> Unit = {}
) {
    val uiState = viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Order Cake")
        Text("Cake Name: ")
        Text("Price: ")
        Text("Quantity: ")
        TextField(
            value = uiState.value.price,
            onValueChange = {viewModel.calculateTotal()}
        )
        Button(onClick = {onBack()}) {
            Text("Back")
        }
    }
}
