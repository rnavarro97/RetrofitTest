package com.revature.implicitintentexample

import android.app.SearchManager
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.revature.implicitintentexample.ui.theme.ImplicitIntentExampleTheme

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImplicitIntentExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var context = LocalContext.current

    Column()
    {
        Button(onClick = {

            val sendIntent = Intent().apply {
                action = Intent.ACTION_SENDTO
                data = Uri.parse("smsto:")
                putExtra( "sms_body","mayur")
                type = "text/plain"
            }
            try
            {
                context.startActivity(sendIntent)
            }
            catch (e: ActivityNotFoundException)
            {
                Log.d("Activity","Not found")
            }

        }) {
            Text(text = "Send Message")
        }
        Button(onClick = {

            val sendIntent = Intent(Intent.ACTION_CALL).apply {
                data = Uri.parse("tel:+13656515237")
            }
            try
            {
                context.startActivity(sendIntent)
            }
            catch (e: ActivityNotFoundException)
            {
                Log.d("Activity","Not found")
            }

        }) {
            Text(text = "CALL")
        }

        Button(onClick = {

            val sendIntent = Intent(Intent.ACTION_WEB_SEARCH).apply {

                putExtra(SearchManager.QUERY,"where is obticoke")
            }
            try
            {
                context.startActivity(sendIntent)
            }
            catch (e: ActivityNotFoundException)
            {
                Log.d("Activity","Not found")
            }

        }) {
            Text(text = "Google Search")
        }

        Button(onClick = {

            val sendIntent = Intent(Intent.ACTION_CALL).apply {
                data = Uri.parse("tel:+13656515237")
            }
            try
            {
                context.startActivity(sendIntent)
            }
            catch (e: ActivityNotFoundException)
            {
                Log.d("Activity","Not found")
            }

        }) {
            Text(text = "CALL")
        }

        Button(onClick = {

            val sendIntent = Intent(Settings.ACTION_WIFI_SETTINGS).apply {

                putExtra(SearchManager.QUERY,"where is obticoke")
            }
            try
            {
                context.startActivity(sendIntent)
            }
            catch (e: ActivityNotFoundException)
            {
                Log.d("Activity","Not found")
            }

        }) {
            Text(text = "Open WiFi settings")
        }

        Button(onClick = {

            val sendIntent = Intent(Intent.ACTION_VIEW).apply {

                val webpage:Uri=Uri.parse("https://www.microsoft.com")
            }
            try
            {
                context.startActivity(sendIntent)
            }
            catch (e: ActivityNotFoundException)
            {
                Log.d("Activity","Not found")
            }

        }) {
            Text(text = "Open Web Link")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ImplicitIntentExampleTheme {
        Greeting("Android")
    }
}