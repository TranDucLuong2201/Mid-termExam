package com.android.mid_termexam.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.android.mid_termexam.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map

// ------------------- DATA -------------------
data class Cake(
    val id: Int,
    val name: String,
    val pricePerUnit: Int = 2
)
val cakes = listOf(
    Cake(1, "Bánh Tỏi"),
    Cake(2, "Bánh Kem"),
    Cake(3, "Bánh Mì"),
    Cake(4, "Bánh Socola")
)
// ------------------- VIEWMODEL -------------------
class DetailViewModel : ViewModel() {

    private val _quantity = MutableStateFlow(1)
    val quantity: StateFlow<Int> = _quantity

    private val _cake = MutableStateFlow<Cake?>(null)
    val cake: StateFlow<Cake?> = _cake

    fun setCakeById(id: Int) {
        _cake.value = cakes.find { it.id == id }
    }

    fun updateQuantity(value: String) {
        _quantity.value = value.toIntOrNull()?.coerceAtLeast(1) ?: 1
    }

    val totalPrice = combine(quantity, cake) { q, c ->
        if (c == null) 0 else q * c.pricePerUnit
    }
}


// ------------------- MAIN -------------------
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                AppNav()
            }
        }
    }
}

// ------------------- NAVIGATION -------------------
@Composable
fun AppNav() {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = "menu") {

        composable("menu") {
            MenuScreen(
                onClick = { id ->
                    nav.navigate("detail/$id")
                }
            )
        }

        composable(
            "detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 1
            DetailScreen(id = id)
        }

    }
}

// ------------------- MENU SCREEN -------------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(onClick: (Int) -> Unit) {



    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Menu Bánh") })
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ) {
            items(cakes) { cake ->
                Card(
                    onClick = { onClick(cake.id) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = cake.name, fontWeight = FontWeight.Bold)
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

// ------------------- DETAIL SCREEN -------------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    id: Int,
    vm: DetailViewModel = viewModel(),
    nav: NavHostController = rememberNavController()
) {
    LaunchedEffect(id) {
        vm.setCakeById(id)
    }

    val cake by vm.cake.collectAsState()
    val quantity by vm.quantity.collectAsState()
    val total by vm.totalPrice.collectAsState(initial = 0)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Chi tiết bánh") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(
                            painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { padding ->
        if (cake == null) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) { Text("Không tìm thấy bánh!") }
        } else {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(20.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(cake!!.name, fontSize = MaterialTheme.typography.titleLarge.fontSize)
                Spacer(Modifier.height(10.dp))
                Text("Giá: ${cake!!.pricePerUnit} / cái")

                Spacer(Modifier.height(25.dp))

                OutlinedTextField(
                    value = quantity.toString(),
                    onValueChange = { vm.updateQuantity(it) },
                    label = { Text("Số lượng") },
                    singleLine = true,
                    modifier = Modifier.width(200.dp)
                )

                Spacer(Modifier.height(30.dp))

                Text("Tổng tiền: $total", fontSize = MaterialTheme.typography.headlineMedium.fontSize)
            }
        }
    }
}
