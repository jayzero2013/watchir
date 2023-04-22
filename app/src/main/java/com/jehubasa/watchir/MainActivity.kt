package com.jehubasa.watchir

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jehubasa.watchir.ui.theme.WatchirTheme
import com.jehubasa.watchir.viewModels.MoviesViewModel
import setUpSpashToMainNavGraph

class MainActivity : ComponentActivity() {
    private lateinit var navController : NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel =MoviesViewModel()
        installSplashScreen().apply {
         this.setKeepVisibleCondition{
             viewModel.isLoaded
         }
        }
        setContent {

            WatchirTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    navController = rememberNavController()
                    setUpSpashToMainNavGraph(navHostController = navController, viewModel)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WatchirTheme {
    }
}