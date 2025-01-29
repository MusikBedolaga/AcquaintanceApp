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
<<<<<<< HEAD

=======
>>>>>>> origin/Musa

@Composable
fun FeedView(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CardFeedView(modifier.padding(top = 100.dp, start = 20.dp, end = 20.dp))

        Spacer(modifier = Modifier.height(30.dp))

        LikeOrDislikeView(modifier.padding(start = 15.dp, end = 15.dp))

        Spacer(modifier = Modifier.weight(1f))

        TabBar()
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FeedViewPreview() {
    AcqAppTheme() {
        FeedView()
    }
}

<<<<<<< HEAD
=======
@Composable
fun LikeOrDislikeView(
    modifier: Modifier = Modifier,
    onLike: () -> Unit = { },
    onDislike: () -> Unit = { }
) {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = onDislike,
            modifier = Modifier
                .size(99.dp, 56.dp)
                .background(colorResource(id = R.color.button_feed_color))
        ) {
            Text(
                text = "Нет",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onLike,
            modifier = Modifier
                .size(99.dp, 56.dp)
                .background(colorResource(id = R.color.button_feed_color))
        ) {
            Text(
                text = "Да",
                fontSize = 32.sp,
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



@Composable
fun TabBar(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier,
        containerColor = colorResource(id = R.color.main_color)
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = "Home"
                )
            },
            selected = true,
            onClick = {}
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = "Profile"
                )
            },
            selected = false,
            onClick = {}
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = "Messages"
                )
            },
            selected = false,
            onClick = {}
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = "Settings"
                )
            },
            selected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun TabBarPreview() {
    AcqAppTheme {
        TabBar()
    }
}

>>>>>>> origin/Musa
