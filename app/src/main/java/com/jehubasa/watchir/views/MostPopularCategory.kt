package com.jehubasa.watchir.views

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jehubasa.watchir.sealedClasses.Screen
import com.jehubasa.watchir.ui.theme.WatchirTheme
import com.jehubasa.watchir.viewModels.MoviesViewModel


@Composable
fun MostPopularCategory(moviesViewModel: MoviesViewModel, navController: NavController) {

    val popularPicked = moviesViewModel.popularMoviesData
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = MaterialTheme.colors.secondary)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Most Popular Movies",
                color = Color.White,
                fontSize = MaterialTheme.typography.h6.fontSize
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow() {
             itemsIndexed(popularPicked.item){index, item ->
                 Box(modifier = Modifier.clickable {
                     Log.d("jehu", "MPM tapped $index")
                     moviesViewModel.getSelectedMovieDetails(item.id)
                     navController.navigate(Screen.selectedMoviesScreen.route)
                 }) {
                     ItemListLayoutTemplate(movie = item)
                 }
             }
            }
        }
    }


@Composable
@Preview
fun NewMoviewPreview() {
    WatchirTheme {
        //MostPopular()
    }
}