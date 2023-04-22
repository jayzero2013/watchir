package com.jehubasa.watchir.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jehubasa.watchir.dataClass.PopularMovieData
import com.jehubasa.watchir.ui.theme.WatchirTheme

@Composable
fun ItemListLayoutTemplate(
    movie: PopularMovieData,
    componentWidth: Dp = 200.dp,
    posterWidth: Dp = 150.dp,
    posterHeight: Dp = 250.dp,
    posterToTitleSpace: Dp = 20.dp,
    titleSize: TextUnit = 15.sp,
    detailsSize: TextUnit = 10.sp,
    titleToDetailsSpace: Dp = 10.dp,
) {

    Column(
        modifier = Modifier
            .width(componentWidth)
            .height(IntrinsicSize.Min),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = movie.poster?.let { BitmapPainter(it.asImageBitmap()) } as Painter,
            contentDescription = "Poster Place holder",
            modifier = Modifier
                .size(width = posterWidth, posterHeight)
                .background(color = Color.White),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(posterToTitleSpace))
        Text(
            text = movie.title!!,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = titleSize
        )
        Spacer(modifier = Modifier.height(titleToDetailsSpace))
        Row {
            Text(text = movie.movieType!!, fontSize = detailsSize, color = Color.White)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "•", fontSize = 10.sp, color = Color.White)
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = movie.voteAverage!!,
                fontSize = detailsSize,
                color = MaterialTheme.colors.primary
            )

        }
    }
}

@Composable
@Preview
fun NewMoviesTemplatePreview() {
    WatchirTheme {
        //NewMoviesTemplate()
    }
}