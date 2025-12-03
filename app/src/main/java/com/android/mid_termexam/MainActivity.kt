package com.android.mid_termexam

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.android.mid_termexam.todo.AppNav
import com.android.mid_termexam.ui.theme.MidtermExamTheme

/**
 * Chỗ này thường sẽ không cần chỉnh sửa gì nhiều, chỉ cần gọi MainNavigation trong Scaffold là được.
 */
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MidtermExamTheme {
                Scaffold(modifier = Modifier.fillMaxSize().statusBarsPadding()) {
                    AppNav()
                }
            }
        }
    }
}
