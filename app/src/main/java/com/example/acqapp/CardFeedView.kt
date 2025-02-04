package com.example.acqapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.acqapp.ui.theme.AcqAppTheme

@Composable
fun CardFeedView(
    modifier: Modifier = Modifier,
    name: String = "Тетя Валя",
    age: Int = 19,
    userStatus: String = "Львица в самом соку"
) {
    Box(
        modifier = modifier
            .background(colorResource(R.color.main_color))
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(15.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.babulya),
                contentDescription = "Описание изображения",
                modifier = Modifier
                    .padding(10.dp)
                    .size(284.dp, 390.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
            ) {
                Text(
                    text = name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.text_feed_color)
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "$age лет",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.text_feed_color)
                )
            }


            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = userStatus,
                fontSize = 17.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.text_feed_color),
                modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                maxLines = Int.MAX_VALUE,
                overflow = TextOverflow.Visible
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun CardFeedViewPreview() {
    AcqAppTheme() {
        CardFeedView(Modifier.width(305.dp).height(560.dp), "Musa", 18, "Львица в самом соку")
    }
}