@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.acqapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegiView(
    modifier: Modifier = Modifier,
    repeatPassword: String,
    onRepeatPasswordChange: (String) -> Unit,
    onRegisterClick: (String, String, String) -> Unit
){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.main_color)),
    ){
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Войти в берлогу",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.text_auth_color),
                modifier = Modifier
                    .padding(top = 170.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

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
                    .padding(top = 63.dp)
                    .background(
                        color = colorResource(R.color.text_feed_color),
                        shape = RoundedCornerShape(25.dp)
                    ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Transparent, // Убирает рамку в неактивном состоянии
                    focusedBorderColor = Color.Transparent    // Убирает рамку в активном состоянии
                )
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        text = "Пароль",
                        color = colorResource(R.color.main_color), // Установка цвета метки
                        fontSize = 16.sp, // Размер шрифта
                    )
                },
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier
                    .padding(top = 15.dp)
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

            OutlinedTextField(
                value = repeatPassword,
                onValueChange = onRepeatPasswordChange,
                label = {
                        Text("Повторите пароль",
                            color = colorResource(R.color.main_color), fontSize = 16.sp)
                },
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier
                    .padding(top = 15.dp)
                    .background(colorResource(R.color.text_feed_color), shape = RoundedCornerShape(25.dp)),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent
                )
            )

            Button(
                onClick = {
                    // Здесь можно добавить проверку на совпадение паролей
                    if (password == repeatPassword) {
                        onRegisterClick(email, password, repeatPassword) // Вызов обработчика регистрации
                    } else {
                        // Реализуйте логику обработки несовпадения паролей, например, показать сообщение
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.text_feed_color)),
                modifier = Modifier
                    .size(275.dp, 200.dp)
                    .padding(top = 130.dp)
                    .background(
                        colorResource(R.color.text_feed_color),
                        shape = RoundedCornerShape(25.dp)
                    ),
                shape = RoundedCornerShape(25.dp)
            ) {
                Text(
                    text = "Зарегистрироваться",
                    fontSize = 20.sp,
                    color = colorResource(R.color.main_color),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .background(colorResource(R.color.text_feed_color))
                )
            }
        }
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun RegiViewPreview() {

        var repeatPassword by remember { mutableStateOf("") }

    RegiView(
        repeatPassword = repeatPassword,
        onRepeatPasswordChange = { repeatPassword = it },
        onRegisterClick = { email, password, repeat ->
            // Логика обработки регистрации
        }
    )

}
