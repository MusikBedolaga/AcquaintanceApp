package com.example.acqapp

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.acqapp.ui.theme.AcqAppTheme

@Composable
fun LikeOrDislikeView(
    modifier: Modifier = Modifier,
    onLike: () -> Unit = { },
    onDislike: () -> Unit = { }
) {
    Row(
        modifier = modifier.wrapContentSize()
    ) {
        Button(
            onClick = onDislike,
            modifier = Modifier
                .size(99.dp, 56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.button_feed_color), // Используем containerColor для Material 3
                contentColor = Color.Black
            )
        ) {
            Text(
                text = "Нет",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onLike,
            modifier = Modifier
                .size(99.dp, 56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.button_feed_color), // Используем containerColor для Material 3
                contentColor = Color.Black
            )
        ) {
            Text(
                text = "Да",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun LikeOrDislikeViewPreview() {
    AcqAppTheme {
        LikeOrDislikeView()
    }
}