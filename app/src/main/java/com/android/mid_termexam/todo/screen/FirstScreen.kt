// File: app/src/main/java/com/android/mid_termexam/todo/screen/FirstScreen.kt
package com.android.mid_termexam.todo.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.mid_termexam.todo.viewmodel.FirstViewModel

@Composable
fun FirstScreen(
    modifier: Modifier = Modifier,
    viewModel: FirstViewModel = viewModel(),
    onAuthSuccess: (String) -> Unit = { }
) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = viewModel.email,
                onValueChange = viewModel::onEmailChange,
                label = { Text("Email") },
                isError = viewModel.email.isNotBlank() && !viewModel.isEmailValid()
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                value = viewModel.password,
                onValueChange = viewModel::onPasswordChange,
                label = { Text("Password (min 6)") },
                singleLine = true,
                isError = viewModel.password.isNotBlank() && !viewModel.isPasswordValid()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    if (viewModel.login()) onAuthSuccess(viewModel.email)
                },
                enabled = viewModel.canSubmit()
            ) {
                Text("Login")
            }
            TextButton(onClick = {
                if (viewModel.register()) onAuthSuccess(viewModel.email)
            }) {
                Text("Register")
            }
        }
    }
}
