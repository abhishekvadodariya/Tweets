package com.tech.tweets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tech.tweets.screens.CategoryScreen
import com.tech.tweets.screens.DetailsScreen
import com.tech.tweets.ui.theme.TweetsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TweetsTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category") {
        composable(route = "category") {
            CategoryScreen {
                navController.navigate("details/{$it}")
            }
        }
        composable(route = "details/{category}", arguments = listOf(navArgument("category") {
            type = NavType.StringType
        })) {
            DetailsScreen()
        }
    }
}
