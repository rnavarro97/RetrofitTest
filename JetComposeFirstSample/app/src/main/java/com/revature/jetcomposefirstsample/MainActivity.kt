package com.revature.jetcomposefirstsample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
//import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import com.revature.jetcomposefirstsample.ui.theme.JetComposeFirstSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            //UI building logic goes here

            //Text(text="Hello Android!")
            MessageCard(Messages("Android","JetCompose"))

        }
    }
}

data class Messages(val author:String, val body:String)



@Composable
fun MessageCard(msg:Messages) {

}

@Preview
@Composable
fun PreviewMessageCard()
{

}