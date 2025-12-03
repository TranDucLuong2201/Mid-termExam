package com.android.mid_termexam.todo.viewmodel

import androidx.lifecycle.ViewModel
import com.android.mid_termexam.todo.model.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

class OrderCakeViewModel : ViewModel() {
    val _uiState = MutableStateFlow(OrderUiState())
    val uiState = _uiState.asStateFlow()
    fun setQuantity(numberCupcakes: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                quantity = numberCupcakes,
                price = calculateTotal(quantity = numberCupcakes)
            )
        }
    }

    fun onQuantityChange(newQuantity: String) {
        _uiState.update { currentState ->
            currentState.copy(
                date = "",
                price = calculateTotal()
            )
        }
    }
    fun setFlavor(desiredFlavor: String) {
        _uiState.update { currentState ->
            currentState.copy(flavor = desiredFlavor)
        }
    }
    fun calculateTotal(
        quantity: Int = _uiState.value.quantity,
        pickupDate: String = _uiState.value.date
    ): String {
        val calculatedPrice = quantity * 2
        // If the user selected the first option (today) for pickup, add the surcharge
        val formattedPrice = NumberFormat.getCurrencyInstance().format(calculatedPrice)
        return formattedPrice
    }
}