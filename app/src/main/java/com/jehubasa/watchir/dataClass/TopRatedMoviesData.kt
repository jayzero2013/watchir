package com.jehubasa.watchir.dataClass

import com.google.gson.annotations.SerializedName


data class TopRatedMoviesData (

    @SerializedName("page"          ) var page         : Int?               = null,
    @SerializedName("results"       ) var results      : ArrayList<TopRatedMoviesDataResults> = arrayListOf(),
    @SerializedName("total_pages"   ) var totalPages   : Int?               = null,
    @SerializedName("total_results" ) var totalResults : Int?               = null

)