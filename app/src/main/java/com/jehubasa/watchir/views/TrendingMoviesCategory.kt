package com.jehubasa.watchir.views

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jehubasa.watchir.sealedClasses.Screen
import com.jehubasa.watchir.viewModels.MoviesViewModel

@Composable
fun TrendingMoviesCategory(moviesViewModel: MoviesViewModel, navController: NavController) {
    val trendingPicked = moviesViewModel.topRatedMoviesData

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {

        Spacer(modifier = Modifier.height(10.dp))
        Row(Modifier.padding(start = 10.dp,end = 10.dp)) {
            Text(text = "Trending Movies", fontSize = 15.sp)
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                Text(text = "See All", fontSize = 15.sp, color = MaterialTheme.colors.primary)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
        ) {
            itemsIndexed(trendingPicked.item) { index, item ->
                Box(modifier = Modifier.clickable {
                    Log.d("jehu", "MPM tapped $index")
                    moviesViewModel.getSelectedMovieDetails(item.id)
                    navController.navigate(Screen.selectedMoviesScreen.route)
                }) {
                    ItemListLayoutTemplate(
                        movie = item,
                        componentWidth = 100.dp,
                        posterHeight = 120.dp,
                        posterWidth = 90.dp,
                        titleSize = 10.sp,
                        detailsSize = 7.sp,
                        posterToTitleSpace = 10.dp,
                        titleToDetailsSpace = 5.dp
                    )
                }
            }
        }
    }
}