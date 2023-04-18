package com.jehubasa.watchir.viewModels

import android.graphics.Bitmap
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jehubasa.watchir.dataClass.MovieDetailsData
import com.jehubasa.watchir.dataClass.PopularMovieData
import com.jehubasa.watchir.dataClass.PopularMovieList
import com.jehubasa.watchir.models.ImdbModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext

class MostPopularMoviesViewModel() : ViewModel() {
    var data by mutableStateOf(PopularMovieList(item = ArrayList()))
    var isLoaded by mutableStateOf(false)

    init {
        initMostPopularMovies()
    }

    fun initMostPopularMovies() {
        viewModelScope.launch() {
            val mostPopularMovies = ImdbModel().getMostPopularMovies()

            Log.d("jehu", mostPopularMovies.results.size.toString())


            var moviesFilteredData = arrayListOf<PopularMovieData>()
            for (item in mostPopularMovies.results) {
                var title: String? = null
                var poster: Bitmap? = null
                var genre: ArrayList<String?> = arrayListOf()
                var releaseYear: String? = null


                getImage(item.posterPath) {
                    poster = it
                }

                getDetails(item.id) {
                    for (genreItem in it.genres) {
                        genre.add(genreItem.name)
                    }
                    releaseYear = it.releaseDate!!.split("-")[0]
                    title = it.title
                }

                moviesFilteredData.add(
                    PopularMovieData(
                        title,
                        poster,
                        genre.toString(),
                        releaseYear
                    )
                )
                Log.d("jehu", "filterSize: ${moviesFilteredData.size}")
            }

            data = PopularMovieList(item = moviesFilteredData)
            Log.d("jehu", "_data. value is loaded")
            isLoaded = !isLoaded
        }
    }

    private suspend fun getImage(image: String?, bitmap: (Bitmap) -> Unit) {
        if (image != null) {
            bitmap(ImdbModel().getImage("https://image.tmdb.org/t/p/w500/$image")!!)
        }
    }

    private suspend fun getDetails(id: Int?, details: (MovieDetailsData) -> Unit) {
        if (id != null) {
            details(ImdbModel().getMovieDetails(id))
        }
    }

}