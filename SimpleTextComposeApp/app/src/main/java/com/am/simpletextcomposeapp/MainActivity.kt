package com.am.simpletextcomposeapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.am.simpletextcomposeapp.ui.theme.SimpleTextComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleTextComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    GreetingButton(this)
                    GreetingText(this, name= "Android")
                }
            }
        }
    }
}



@Composable
fun GreetingText(context: Context,name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier
            .width(250.dp)
            .height(240.dp)
            .padding(all = 24.dp)
            .clickable {
                Toast
                    .makeText(context, "trilu", Toast.LENGTH_SHORT)
                    .show()
            },
//        style = TextStyle(
//            color = Color.Magenta,
//            fontWeight = FontWeight.Bold,
//            fontSize = 30.sp
//        )
        style = MaterialTheme.typography.h6,
        fontWeight = FontWeight.Bold,
        color = Color.Magenta
    )
}

@Composable
fun GreetingButton(context: Context) {
    Button(onClick = { }) {
        GreetingText(context = context, name = "Button")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewMainActivity() {
    SimpleTextComposeAppTheme {
//        GreetingButton(LocalContext.current)
        GreetingText(LocalContext.current, "Android")
    }
}