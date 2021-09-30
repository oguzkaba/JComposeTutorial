package com.example.jcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jcomposetutorial.ui.theme.JComposeTutorialTheme
import com.example.jcomposetutorial.view.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            JComposeTutorialTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                NavHost(navController = navController, startDestination = "todolist") {
                    composable("login") {
                        LoginScreen(navController=navController)
                    }
                    composable("signup") {
                        SignUpScreen(navController=navController)
                    }
                    composable("nick") {
                        CreateNick(navController=navController)
                    }
                    composable("todolist") {
                        TodoListScreen(navController=navController)
                    }
                    composable("addtodo") {
                        AddTaskScreen(navController=navController)
                    }
                }
            }
        }
    }
}





/*@Preview(showBackground = true,device = "name:PIXEL_4_XL",showSystemUi = false)
@Composable
fun DefaultPreview() {
    JComposeTutorialTheme {
        LoginScreen()
    }
}*/
