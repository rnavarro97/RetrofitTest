package com.revature.jetcomposefirstsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
//import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.revature.jetcomposefirstsample.ui.theme.JetComposeFirstSampleTheme
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetComposeFirstSampleTheme {
                Surface(
                    modifier=Modifier.fillMaxSize(),
                    color=MaterialTheme.colors.background
                ){
                    val navController=rememberNavController()
                    NavHost(navController=navController,        //container of navigation graph
                    startDestination=Screen.Login_Screen.route)
                    {


                        composable(Screen.Login_Screen.route)
                        {
                            LoginScreen(navController)
                        }

                        //profile


                        composable(route=Screen.Profile_Screen.route+
                                "/{name}/{userId}/{timestamp}",
                                arguments=listOf(

                                    navArgument("name")
                                    {
                                        type= NavType.StringType
                                    },
                                    navArgument("userId")
                                    {
                                        type= androidx.navigation.NavType.StringType
                                    },
                                    navArgument("timestamp")
                                    {
                                        type= NavType.LongType
                                    }

                                )
                        )
                        {
                            var name=it.arguments?.getString("name")
                            var userId=it.arguments?.getString("userId")
                            var timestamp=it.arguments?.getLong("timestamp")
                            if (name != null) {
                                if (userId != null) {
                                    if (timestamp != null) {
                                        ProfileScreen(navController = navController,
                                            name =name, userId =userId,
                                            created =timestamp)
                                    }
                                }
                            }
                        }
                    composable(Screen.Post_Screen.route+"/{showPost}",
                        arguments=listOf(

                            navArgument("showPost")
                            {
                                type= NavType.BoolType
                                defaultValue=false
                            }
                        )
                    )
                    {
                        val showPostNew=it.arguments?.getBoolean("showPost")?:false
                        PostScreen(showPostNew)
                    }
                    }
                }
            }


        }
    }
}

//data class Messages(val author:String, val body:String)


@Composable
fun LoginScreen(navController:NavController)
{
    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement=Arrangement.Center,
        horizontalAlignment=Alignment.CenterHorizontally
    )
    {

        Button(onClick={navController.navigate(Screen.Profile_Screen.route+"/Rick/6980/1234567890")})
        {
            Text("LoginScreen")

        }

    }
}

@Composable
fun ProfileScreen(navController:NavController,
                  name:String,
                  userId:String, created:Long)
{

    val user=rememberSaveable{
        User(
            name =name,
            id =userId,
            created= LocalDateTime.ofInstant(Instant
                    .ofEpochMilli(created),
                    ZoneId.systemDefault()
            )
        )
    }
    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement=Arrangement.Center,
        horizontalAlignment=Alignment.CenterHorizontally
    ){
        Text(text="ProfileScreen: $user",textAlign= TextAlign.Center)

        Button(onClick=
        {

            navController.navigate("Screen.Post_Screen.route/true")
        }
        )
        {
            Text(text="Go to Post Screen")
        }
    }
}

@Composable
fun PostScreen(showPost:Boolean=false)
{
    Box(modifier=Modifier.fillMaxSize(),
    contentAlignment=Alignment.Center)
    {
        Text(text="Post Screen $showPost")
    }
}


//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun textFieldExample()
//{
//    Column(
//        horizontalAlignment=Alignment.CenterHorizontally,
//        modifier=Modifier.fillMaxWidth()
//            .padding(20.dp)
//            .border(1.dp, Color.Red, RectangleShape)
//    )
//    {
//        var username by rememberSaveable{ mutableStateOf("")}
//        var password by rememberSaveable{mutableStateOf("")}
//
//        TextField(value=username,
//            onValueChange={username=it},
//            label={Text("User Name:")})
//        Spacer(modifier = Modifier.size(4.dp))
//        Text(username)
//        Spacer(modifier=Modifier.size(4.dp))
//        TextField(value=password,
//            onValueChange={password=it},
//            label={Text("Password")})
//        Spacer(modifier=Modifier.size(4.dp))
//        Text(password)
//
//        var success by rememberSaveable{mutableStateOf("")}
//        Button(onClick={success=compare(username,password)}){Text("Login")}
//        Text(success)
//    }
//
//}

//fun compare(username:String, password:String): String {
//
//    if(username=="rnavarro97"&&password=="feverdream")
//    {
//        return "Successful"
//    }
//    else
//    {
//        return "Unsuccessful"
//    }
//}


@Preview
@Composable
fun PreviewMessageCard()
{
//    UserInterface()

}