package com.jehubasa.watchir.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jehubasa.watchir.R
import com.jehubasa.watchir.dataClass.PopularMovieData
import com.jehubasa.watchir.ui.theme.WatchirTheme

@Composable
fun NewMoviesTemplate(
    movie: PopularMovieData
) {

    Column(
        modifier = Modifier
            .width(200.dp)
            .height(IntrinsicSize.Min),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = movie.poster?.let { BitmapPainter(it.asImageBitmap()) } as Painter,
            contentDescription = "Poster Place holder",
            modifier = Modifier
                .size(width = 150.dp, height = 250.dp)
                .background(color = Color.White),
            contentScale = ContentScale.FillHeight
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = movie.title!!, color = Color.White)
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Text(text = movie.movieType!!, fontSize = 10.sp, color = Color.White)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "•", fontSize = 10.sp, color = Color.White)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = movie.genre!!, fontSize = 10.sp, color = Color.White)

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