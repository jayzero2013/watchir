package com.jehubasa.watchir.views

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jehubasa.watchir.R
import com.jehubasa.watchir.sealedClasses.Screen
import com.jehubasa.watchir.ui.theme.WatchirTheme
import com.jehubasa.watchir.viewModels.MostPopularMoviesViewModel

@Composable
fun SplashScreen(
    navController: NavController,
    mostPopularMoviesModel: MostPopularMoviesViewModel
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        colorResource(id = R.color.grey),
                        Color.Black
                    ), radius = 500f
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.watchir_logo_png),
            contentDescription = "Watchir Logo"
        )

        CircularProgressIndicator(
            modifier = Modifier.size(20.dp),
            color = MaterialTheme.colors.primary
        )

        if (mostPopularMoviesModel.isLoaded){
            Log.d("jehu", "load main Screen")
            navController.navigate(Screen.mainScreen.route)
            mostPopularMoviesModel.isLoaded = false
        }
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    WatchirTheme {
        //SplashScreen(navController = rememberNavController())

    }
}