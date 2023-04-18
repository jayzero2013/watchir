package com.jehubasa.watchir.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jehubasa.watchir.dataClass.PopularMovieData
import com.jehubasa.watchir.dataClass.PopularMovieList
import com.jehubasa.watchir.ui.theme.WatchirTheme
import com.jehubasa.watchir.viewModels.MostPopularMoviesViewModel

@Composable
fun MostPopular(mostPopularMoviesViewModel: MostPopularMoviesViewModel) {

    val popularPicked = mostPopularMoviesViewModel.data

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Color.Black)
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

        LazyRow {
            items(
                popularPicked.item.size
            ) {
                popularPicked.item.forEach { data ->

                    NewMoviesTemplate(movie = data)
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