package com.example.timenest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.timenest.Screens.LoginScreen
import com.example.timenest.Screens.SignupScreen
import com.example.timenest.ui.theme.TimeNestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimeNestTheme {
                SignupScreen()
            }
        }
    }
}

