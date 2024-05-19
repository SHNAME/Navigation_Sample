package com.example.navigationsample
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Myapp()
                }
            }
        }
    }
}

@Composable
fun Myapp()
{
    val  navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "firstscreen")
    {
        composable("firstscreen"){
            FirstScreen {name ->
                navController.navigate("secondscreen/$name")
            }

        }
        composable( "secondscreen/{name}"){
           val name = it.arguments?.getString("name")?:"no name"
            //backstack에서 인수를 받아오는데 key는 name이고 key가 없을 경우 no name이 변수에 들어간다.
            SecondScreen(name) {
                navController.navigate("firstscreen")

            }

        }



    }





}


