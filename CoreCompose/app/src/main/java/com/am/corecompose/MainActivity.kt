package com.am.corecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                coloredSquare(myColor = Color.Red)
                coloredSquare(myColor = Color.Magenta)
            }
            coloredSquare(myColor = Color.Cyan)
            coloredSquare(myColor = Color.Blue)
            coloredSquare(myColor = Color.Yellow)
            coloredSquare(myColor = Color.Green)

        }
    }
}

@Composable
fun coloredSquare(myColor: Color) {
    Surface(
        color = myColor,
        modifier = Modifier
            .height(50.dp)
            .width(50.dp)
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