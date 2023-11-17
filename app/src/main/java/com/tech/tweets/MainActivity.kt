package com.tech.tweets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tech.tweets.screens.DetailsScreen
import com.tech.tweets.ui.theme.TweetsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TweetsTheme {
                // A surface container using the 'background' color from the theme
                CategoryScreen()
                DetailsScreen()
            }
        }
    }
}
