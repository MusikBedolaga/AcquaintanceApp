package com.example.acqapp

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainView() {
    var currentScreen by remember { mutableStateOf(Screen.Auth) }
    var repeatPassword by remember { mutableStateOf("") }

    when (currentScreen) {
        Screen.Auth -> AuthView(
            onLoginClick = { email, password ->
                currentScreen = Screen.Feed
            },
            onRegisterClick = {
                currentScreen = Screen.Register
            }
        )
        Screen.Register -> RegiView(
            repeatPassword = repeatPassword,
            onRepeatPasswordChange = { repeatPassword = it },
            onRegisterClick = { email, password, _ ->
                currentScreen = Screen.Feed
            }
        )
        Screen.Feed -> FeedView()
    }
}


enum class Screen {
    Auth,
    Register,
    Feed
}


