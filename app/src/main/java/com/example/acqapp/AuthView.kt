@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.acqapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.acqapp.ui.theme.AcqAppTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.acqapp.R
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@Composable
fun AuthView(
    modifier: Modifier = Modifier,
    onLoginClick: (String, String) -> Unit,
    onRegisterClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.main_color)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .background(colorResource(R.color.main_color)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Войти в берлогу",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.text_auth_color),
                modifier = Modifier
                    .padding(top = 180.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Email Input
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(
                        text = "Email",
                        color = colorResource(R.color.main_color), // Установка цвета метки
                        fontSize = 16.sp, // Размер шрифта
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .padding(top = 73.dp)
                    .background(
                        color = colorResource(R.color.text_feed_color),
                        shape = RoundedCornerShape(25.dp)
                    ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Transparent, // Убирает рамку в неактивном состоянии
                    focusedBorderColor = Color.Transparent    // Убирает рамку в активном состоянии
                )
            )

            Spacer(modifier = Modifier.height(25.dp))

            // Password Input
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        text = "Пароль",
                        color = colorResource(R.color.main_color), // Установка цвета метки
                        fontSize = 16.sp, // Размер шрифта
                        modifier = Modifier
                    )
                },
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier
                    .background(Color.Transparent)
                    .background(
                        color = colorResource(R.color.text_feed_color),
                        shape = RoundedCornerShape(25.dp)
                    ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Transparent, // Убирает рамку в неактивном состоянии
                    focusedBorderColor = Color.Transparent, // Убирает рамку в активном состоянии
                )
            )

            Button(
                onClick = { onLoginClick(email, password) },
                modifier = Modifier
                    .size(260.dp, 130.dp)
                    .padding(top = 70.dp)
                    .shadow(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.text_feed_color)),
                shape = RoundedCornerShape(20.dp), // Закруглённые углы
            ) {
                Text(
                    text = "Войти",
                    fontSize = 24.sp,
                    color = colorResource(R.color.text_auth_ref_reg_color)
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 100.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Нет берлоги? ",
                    color = colorResource(R.color.text_auth_color),
                    fontSize = 16.sp
                )
                Text(
                    text = "Зарегистрироваться",
                    color = colorResource(R.color.text_auth_ref_reg_color),
                    fontSize = 16.sp,
                    modifier = Modifier.clickable { onRegisterClick() }
                )
            }
        }
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AuthViewPreview() {
    AuthView(
        onLoginClick = { email, password -> /* Обработка входа */ },
        onRegisterClick = { /* Обработка регистрации */ }
    )
}


