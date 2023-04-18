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
    var title : String? = null,
    var poster : Bitmap? =null,
    var genre : String? =null,
    var movieType: String? = null
):Parcelable