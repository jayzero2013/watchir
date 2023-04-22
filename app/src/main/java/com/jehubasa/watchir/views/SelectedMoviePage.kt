package com.jehubasa.watchir.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jehubasa.watchir.ui.theme.WatchirTheme
import com.jehubasa.watchir.viewModels.MoviesViewModel
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun SelectedMoviePage(moviesViewModel: MoviesViewModel) {
    val selectedMovieData = moviesViewModel.selectedMovieData
    val state = rememberCollapsingToolbarScaffoldState()

    CollapsingToolbarScaffold(
        modifier = Modifier,
        state = state,
        scrollStrategy = ScrollStrategy.EnterAlways,
        toolbar = {
            SelectedMoviePageHeader(moviesViewModel.selectedMovieData)
        }) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "Overview")
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = selectedMovieData.movieDetails?.overview!!,
                fontSize = 13.sp, textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Genre")
            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                selectedMovieData.movieDetails.genres.forEach {
                    Text(
                        text = it.name!!,
                        fontSize = 13.sp, textAlign = TextAlign.Justify
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 20.dp), horizontalArrangement = Arrangement.Center) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Watch Now", color = MaterialTheme.colors.primaryVariant)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSelectedMoviePage() {
    WatchirTheme {
        //SelectedMoviePage()
    }
}