package com.jehubasa.watchir.interfaces

import com.jehubasa.watchir.dataClass.MostPopularMoviesData
import com.jehubasa.watchir.dataClass.MovieDetailsData
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface IMDBApiInterface {
    @GET("movie/popular")
    suspend fun getMostPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ):MostPopularMoviesData

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "en-US"
    ): MovieDetailsData

    @GET()
    suspend fun getImage(@Url url: String): ResponseBody
}