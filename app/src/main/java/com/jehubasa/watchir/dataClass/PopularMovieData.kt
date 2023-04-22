package com.jehubasa.watchir.dataClass

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PopularMovieList(
    var item:ArrayList<PopularMovieData>
): Parcelable

@Parcelize
data class PopularMovieData(
    var id : Int? = null,
    var title : String? = null,
    var poster : Bitmap? =null,
    var voteAverage : String? =null,
    var movieType: String? = null
):Parcelable