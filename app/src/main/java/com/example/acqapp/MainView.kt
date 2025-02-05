package com.example.acqapp

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun MainView(viewModel: UserViewModel) {
    var currentScreen by remember { mutableStateOf(Screen.Auth) }
    var repeatPassword by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    when (currentScreen) {
        Screen.Auth -> AuthView(
            onLoginClick = { email, password ->
                // Здесь выполняем аутентификацию
                viewModel.authenticateUserAsync(email, password) { result ->
                    when (result) {
                        is UserResult.Success -> {
                            // Успешно аутентифицирован, переходим на экран фида
                            currentScreen = Screen.Feed
                        }
                        is UserResult.Error -> {
                            errorMessage = result.message // показываем сообщение об ошибке
                        }
                    }
                }
            },
            onRegisterClick = {
                currentScreen = Screen.Register
            }
        )
        Screen.Register -> RegiView(
            repeatPassword = repeatPassword,
            onRepeatPasswordChange = { repeatPassword = it },
            onRegisterClick = { email, password ->
                viewModel.addUserAsync(email, password) { result ->
                    when (result) {
                        is UserResult.Success -> {
                            currentScreen = Screen.Feed
                        }
                        is UserResult.Error -> {
                            errorMessage = result.message // выводим сообщение об ошибке
                        }
                    }
                }
            }
        )
        Screen.Feed -> FeedView(viewModel = viewModel)
    }

    // Сообщение об ошибке (если есть)
    if (errorMessage.isNotEmpty()) {
        Text(
            text = errorMessage,
            color = Color.Red,
            modifier = Modifier.padding(16.dp)
        )
    }
}




enum class Screen {
    Auth,
    Register,
    Feed
}


