package com.example.acqapp

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.acqapp.ui.theme.AcqAppTheme
import androidx.compose.material3.Button
import androidx.compose.runtime.rememberUpdatedState

@Composable
fun FeedView(viewModel: UserViewModel, modifier: Modifier = Modifier) {
    val currentUser = viewModel.getCurrentUser()

    Column(modifier = Modifier.fillMaxSize()) {
        if (currentUser != null) {
            CardFeedView(
                modifier = modifier.padding(top = 100.dp, start = 20.dp, end = 20.dp),
                name = currentUser.email,
                age = 19,
                userStatus = "Львица в самом соку"
            )

            Spacer(modifier = Modifier.height(30.dp))

            LikeOrDislikeView(
                modifier = Modifier.padding(start = 15.dp, end = 15.dp),
                onLike = {
                    viewModel.nextUser()
                },
                onDislike = {
                    viewModel.previousUser()
                }
            )
        } else {
            Text("Нет пользователей для отображения")
        }

        Spacer(modifier = Modifier.weight(1f))

        TabBar()
    }
}



@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FeedViewPreview() {
    AcqAppTheme() {
//        FeedView()
    }
}

