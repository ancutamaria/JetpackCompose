package com.am.profilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.am.profilecard.ui.theme.MyTheme
import com.am.profilecard.ui.theme.lightGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MainScreen(userProfileList)
            }
        }
    }
}

@Composable
fun MainScreen(userProfiles: List<UserProfile> = userProfileList) {
    Scaffold(
        topBar = { AppBar() }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn {
               items(userProfiles) { userProfile ->
                   ProfileCard(userProfile = userProfile)
               }
            }
        }

    }
}

@Composable
fun AppBar() {
    TopAppBar(
        navigationIcon = { Icon(
            Icons.Default.Home,
            "Navigation Icon",
            Modifier.padding(horizontal = 12.dp)
        ) },
        title = { Text( "Messaging app users") }
    )
}

@Composable
fun ProfileCard(userProfile: UserProfile) {
    Card(
        modifier = Modifier
            .padding(
                top = 8.dp,
                bottom = 4.dp,
                start = 16.dp,
                end = 16.dp
            )
            .fillMaxWidth()
            .wrapContentHeight(
                align = Alignment.Top
            ),
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(userProfile.drawableId, userProfile.status)
            ProfileContent(userProfile.name, userProfile.status)
        }
    }
}


@Composable
fun ProfilePicture(drawableId: Int, onlineStatus: Boolean) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = if (onlineStatus)
                        MaterialTheme.colors.lightGreen
                    else Color.Gray,
        ),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = drawableId),
            contentDescription = "Profile picture",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileContent(username: String, onlineStatus: Boolean) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        CompositionLocalProvider(LocalContentAlpha provides if (onlineStatus) ContentAlpha.high else ContentAlpha.medium) {
            Text(
                text = username,
                style = MaterialTheme.typography.h5
            )
        }
        CompositionLocalProvider(LocalContentAlpha provides if (onlineStatus) ContentAlpha.medium else ContentAlpha.disabled) {
            Text(
                text = if (onlineStatus)
                           "Active now"
                       else "Offline",
                style = MaterialTheme.typography.body2
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTheme {
        MainScreen(userProfileList)
    }
}