// File: app/src/main/java/com/android/mid_termexam/todo/screen/ThirdScreen.kt
package com.android.mid_termexam.todo.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.mid_termexam.todo.viewmodel.ThirdViewModel

@Composable
fun ThirdScreen(onBack: () -> Unit, vm: ThirdViewModel = viewModel()) {
    val slider = vm.slider.collectAsState()
    val selected = vm.selected.collectAsState()
    val expanded = vm.expanded.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {

        Text("Third Screen",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(Modifier.height(16.dp))

        Text("Slider Value = ${slider.value}", color = MaterialTheme.colorScheme.tertiary)

        Slider(
            value = slider.value,
            onValueChange = vm::setSlider,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.primary,
                activeTrackColor = MaterialTheme.colorScheme.primary
            )
        )

        Spacer(Modifier.height(16.dp))

        Text("Radio Buttons:", color = MaterialTheme.colorScheme.secondary)

        Row {
            RadioButton(
                selected = selected.value == "A",
                onClick = { vm.setSelected("A") },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.primary
                )
            )
            Text("Option A")

            Spacer(Modifier.width(16.dp))

            RadioButton(
                selected = selected.value == "B",
                onClick = { vm.setSelected("B") },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.primary
                )
            )
            Text("Option B")
        }

        Spacer(Modifier.height(16.dp))

        // Dropdown
        Box {
            Button(
                onClick = { vm.setExpanded(true) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary
                )
            ) {
                Text(selected.value, color = MaterialTheme.colorScheme.onTertiary)
            }

            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { vm.setExpanded(false) }
            ) {
                listOf("A", "B", "C").forEach { item ->
                    DropdownMenuItem(
                        text = { Text(item) },
                        onClick = {
                            vm.setSelected(item)
                            vm.setExpanded(false)
                        }
                    )
                }
            }
        }

        Spacer(Modifier.weight(1f))

        Button(onClick = onBack) {
            Text("Back")
        }
    }
}
