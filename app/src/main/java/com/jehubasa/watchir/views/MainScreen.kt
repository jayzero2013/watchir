package com.jehubasa.watchir.views

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.jehubasa.watchir.viewModels.MostPopularMoviesViewModel

@Composable
fun MainScreen(mostPopularMoviesViewModel: MostPopularMoviesViewModel){
    Column() {
        MostPopular(mostPopularMoviesViewModel)
    }
}