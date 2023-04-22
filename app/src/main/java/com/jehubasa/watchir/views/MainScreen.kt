package com.jehubasa.watchir.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.jehubasa.watchir.viewModels.MoviesViewModel

@Composable
fun MainScreen(moviesViewModel: MoviesViewModel, navController: NavController){
    LazyColumn(){
        item {
            MostPopularCategory(moviesViewModel, navController = navController)
            TrendingMoviesCategory(moviesViewModel = moviesViewModel, navController = navController)
        }
    }
}