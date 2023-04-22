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
import com.jehubasa.watchir.dataClass.SelectedMovieData
import com.jehubasa.watchir.models.TmdbModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MoviesViewModel() : ViewModel() {
    var popularMoviesData by mutableStateOf(PopularMovieList(item = ArrayList()))
    var topRatedMoviesData by mutableStateOf(PopularMovieList(item = ArrayList()))
    var selectedMovieData by mutableStateOf(
        SelectedMovieData(
            movieDetails = null,
            poster = null,
            banner = null
        )
    )
    var isLoaded by mutableStateOf(true)

    init {
        initMovies()
    }

    fun initMovies() {
        val popularMoviesJob = viewModelScope.launch(Dispatchers.IO) {
            initPopularMovies()
        }
        val topRatedMoviesJob = viewModelScope.launch(Dispatchers.IO) {
            initTopRatedMovies()
        }

        runBlocking {
            popularMoviesJob.join()
            topRatedMoviesJob.join()

            isLoaded = !isLoaded
        }
    }

    private suspend fun initTopRatedMovies() {
        val topRatedMovies = TmdbModel().getTopRatedMovies()

        Log.d("jehu", "Top Rated: ${topRatedMovies.results.size.toString()}")

        val moviesFilteredData = arrayListOf<PopularMovieData>()
        for (item in topRatedMovies.results) {
            val title = item.title
            var poster: Bitmap? = null
            val voteAverage = "Rating: ${"%.1f".format(item.voteAverage)}"
            val releaseYear = item.releaseDate!!.split("-")[0]



            getImage(item.posterPath) {
                poster = it
            }

            moviesFilteredData.add(
                PopularMovieData(
                    item.id,
                    title,
                    poster,
                    voteAverage,
                    releaseYear
                )
            )
            Log.d("jehu", "topRated_filterSize: ${moviesFilteredData.size}")
        }

        topRatedMoviesData = PopularMovieList(item = moviesFilteredData)
        Log.d("jehu", "topRated_data. value is loaded")
    }

    private suspend fun initPopularMovies() {
        val mostPopularMovies = TmdbModel().getMostPopularMovies()

        Log.d("jehu", "most Popular: ${mostPopularMovies.results.size.toString()}")
        val moviesFilteredData = arrayListOf<PopularMovieData>()
        for (item in mostPopularMovies.results) {
            val title = item.title
            var poster: Bitmap? = null
            val voteAverage = "Rating: ${"%.1f".format(item.voteAverage)}"
            val releaseYear = item.releaseDate!!.split("-")[0]



            getImage(item.posterPath) {
                poster = it
            }

            moviesFilteredData.add(
                PopularMovieData(
                    item.id,
                    title,
                    poster,
                    voteAverage,
                    releaseYear
                )
            )
            Log.d("jehu", "popularMovies_filterSize: ${moviesFilteredData.size}")
        }

        popularMoviesData = PopularMovieList(item = moviesFilteredData)
        Log.d("jehu", "popularMovies_data. value is loaded")
    }

    private suspend fun getImage(image: String?, bitmap: (Bitmap) -> Unit) {
        if (image != null) {
            bitmap(TmdbModel().getImage("https://image.tmdb.org/t/p/w500/$image")!!)
        }
    }

    private suspend fun getDetails(id: Int?, details: (MovieDetailsData) -> Unit) {
        if (id != null) {
            details(TmdbModel().getMovieDetails(id))
        }
    }

    fun getSelectedMovieDetails(id: Int?) {

        var details: MovieDetailsData? = null
        val detailsJob =
            viewModelScope.launch(Dispatchers.IO) { details = TmdbModel().getMovieDetails(id!!) }

        var posterJob: Job
        var poster: Bitmap? = null
        runBlocking {
            detailsJob.join()
            posterJob = viewModelScope.launch(Dispatchers.IO) {
                poster =
                    TmdbModel().getImage("https://image.tmdb.org/t/p/w500/${details?.posterPath}")
            }
        }

        var bannerJob: Job
        var banner: Bitmap? = null
        runBlocking {
            posterJob.join()
            bannerJob = viewModelScope.launch(Dispatchers.IO) {
                banner =
                    TmdbModel().getImage("https://image.tmdb.org/t/p/w500/${details?.backdropPath}")
            }
        }

        runBlocking {
            bannerJob.join()
            selectedMovieData =
                SelectedMovieData(movieDetails = details, poster = poster, banner = banner)
            Log.d("jehu", "getting selected movie with the id of $id")
        }
    }

}