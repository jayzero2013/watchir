package com.jehubasa.watchir.dataClass

import android.graphics.Bitmap

data class SelectedMovieData(
    val movieDetails : MovieDetailsData?,
    val poster: Bitmap?,
    val banner: Bitmap?
)
