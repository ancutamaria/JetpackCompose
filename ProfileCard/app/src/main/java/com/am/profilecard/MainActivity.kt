package com.am.profilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import coil.transform.CircleCropTransformation
import com.am.profilecard.ui.theme.MyTheme
import com.am.profilecard.ui.theme.lightGreen
import com.google.accompanist.coil.rememberCoilPainter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                UserProfileApp()
            }
        }
    }
}

@Composable
fun UserProfileApp(
    userProfiles: List<UserProfile> = userProfileList
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "userProfile_list") {
        composable("userProfile_list") {
            UserProfileListScreen(
                userProfiles,
                navController
            )
        }
        composable(
            route = "userProfile_details/{userProfileId}",
            arguments = listOf(navArgument("userProfileId") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            UserProfileDetailsScreen(navBackStackEntry.arguments!!.getInt("userProfileId"))
        }
    }
}

@Composable
fun UserProfileListScreen(
    userProfiles: List<UserProfile>,
    navController: NavController?
) {
    Scaffold(
        topBar = { AppBar() }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn {
                items(userProfiles) { userProfile ->
                    ProfileCard(userProfile = userProfile) {
                        navController?.navigate("userProfile_details/${userProfile.id}")
                    }
                }
            }
        }

    }
}

@Composable
fun UserProfileDetailsScreen(
    userProfileId: Int
) {
    val userProfile = userProfileList.first {
        it.id == userProfileId
    }
    Scaffold(
        topBar = { AppBar() }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                ProfilePicture(userProfile.pictureUrl, userProfile.status, 240.dp)
                ProfileContent(userProfile.name, userProfile.status, Alignment.CenterHorizontally)
            }
        }

    }
}

@Composable
fun AppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                Icons.Default.Home,
                "Navigation Icon",
                Modifier.padding(horizontal = 12.dp)
            )
        },
        title = { Text("Messaging app users") }
    )
}

@Composable
fun ProfileCard(
    userProfile: UserProfile,
    clickAction: () -> Unit
) {
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
            )
            .clickable(onClick =  clickAction ),
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(userProfile.pictureUrl, userProfile.status, 72.dp)
            ProfileContent(userProfile.name, userProfile.status, Alignment.Start)
        }
    }
}

@Composable
fun ProfilePicture(
    pictureUrl: String,
    onlineStatus: Boolean,
    imageSize: Dp
) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = if (onlineStatus)
                MaterialTheme.colors.lightGreen
            else Color.Gray,
        ),
        modifier = Modifier
            .padding(16.dp)
            .size(imageSize),
        elevation = 4.dp
    ) {
        Image(
            painter = rememberCoilPainter(
                request = pictureUrl,
                requestBuilder = {
                    transformations(CircleCropTransformation())
                },
            ),
            contentDescription = "ProfilePic",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileContent(
    username: String,
    onlineStatus: Boolean,
    alignment: Alignment.Horizontal
) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = alignment
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
fun UserListPreview() {
    MyTheme {
        UserProfileDetailsScreen(5)
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileDetailsPreview() {
    MyTheme {
        UserProfileListScreen(userProfileList, null)
    }
}


