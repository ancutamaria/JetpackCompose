package com.am.corecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun MainScreen() {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize()
        ) {
        Row (
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            horizontalColoredBar(myColor = Color.Blue)
            horizontalColoredBar(myColor = Color.Magenta)
            horizontalColoredBar(myColor = Color.Red)
            horizontalColoredBar(myColor = Color.Yellow)
            horizontalColoredBar(myColor = Color.Green)
            horizontalColoredBar(myColor = Color.Cyan)
        }
    }
}

@Composable
fun horizontalColoredBar(myColor: Color) {
    Surface(
        color = myColor,
        modifier = Modifier
            .height(300.dp)
            .width(20.dp)
    ) { }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
//    Text(
//        text = "Wrapped content",
//        style = MaterialTheme.typography.h5,
//        color = Color.DarkGray,
//    )
//    Text(
//        text = "2nd wrapped content",
//        style = MaterialTheme.typography.h5,
//        color = Color.DarkGray,
//    )
}