package com.jehubasa.watchir.models

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.jehubasa.watchir.dataClass.MostPopularMoviesData
import com.jehubasa.watchir.dataClass.MovieDetailsData
import com.jehubasa.watchir.interfaces.IMDBApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ImdbModel(
    private val apiKey: String = "9dfb139215df70a0a50ef2788710214a",
    baseUrl: String = "https://api.themoviedb.org/3/"
) {

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS).build()
        )
        .build()

    private val imdbApi = retrofit.create(IMDBApiInterface::class.java)

    suspend fun getMostPopularMovies(): MostPopularMoviesData {
        return imdbApi.getMostPopularMovies(apiKey)
    }

    suspend fun getMovieDetails(id: Int): MovieDetailsData {
        Log.d("jehu", "id: $id")
        return imdbApi.getMovieDetails(apiKey = apiKey, movieId = id)
    }

    suspend fun getImage(url: String): Bitmap?  {
        val retrofitImage = Retrofit.Builder()
            .baseUrl("https://image.tmdb.org/t/p/w500/")
            .client(OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val imageAPi = retrofitImage.create(IMDBApiInterface::class.java)
        val response = imageAPi.getImage(url)
        val inputStream = response.byteStream()
        return BitmapFactory.decodeStream(inputStream)
    }
}