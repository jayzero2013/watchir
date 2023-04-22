package com.jehubasa.watchir.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jehubasa.watchir.dataClass.SelectedMovieData
import com.jehubasa.watchir.ui.theme.WatchirTheme

@Composable
fun SelectedMoviePageHeader(movieDetailsData: SelectedMovieData) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = movieDetailsData.banner?.let { BitmapPainter(it.asImageBitmap()) } as Painter,
            contentDescription = "poster Big",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        0F to Color.Transparent,
                        .5F to Color.Black.copy(alpha = 0.5F),
                        1F to Color.Black.copy(alpha = 0.7F)
                    )
                )
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Box(modifier = Modifier.size(width = 60.dp, height = 100.dp)) {
                    Image(
                        painter = movieDetailsData.poster?.let { BitmapPainter(it.asImageBitmap()) } as Painter,
                        contentDescription = "poster Big",
                        contentScale = ContentScale.FillHeight
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 20.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = movieDetailsData.movieDetails?.title!!, fontSize = MaterialTheme.typography.h5.fontSize)

                    Row {
                        Text(
                            text = "Rating: ${"%.1f".format(movieDetailsData.movieDetails?.voteAverage)}",
                            fontSize = 10.sp
                        )
                        Text(
                            text = "(${movieDetailsData.movieDetails?.voteCount} votes)",
                            fontSize = 10.sp,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                        Text(
                            text = "•", fontSize = 10.sp,
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                        )
                        Text(
                            text = "${
                                movieDetailsData.movieDetails?.releaseDate?.split("-")?.get(0)
                            }",
                            fontSize = 10.sp,
                        )
                    }
                }
            }
        }


    }
}


@Composable
@Preview
fun PreviewSelectedMoviePageHeader() {
    WatchirTheme() {
    }
}