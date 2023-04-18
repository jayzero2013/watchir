package com.jehubasa.watchir.dataClass

import com.google.gson.annotations.SerializedName

data class MovieDetailsData(
    @SerializedName("adult"                 ) var adult               : Boolean?                       = null,
    @SerializedName("backdrop_path"         ) var backdropPath        : String?                        = null,
    @SerializedName("budget"                ) var budget              : Int?                           = null,
    @SerializedName("genres"                ) var genres              : ArrayList<GenresData>              = arrayListOf(),
    @SerializedName("homepage"              ) var homepage            : String?                        = null,
    @SerializedName("id"                    ) var id                  : Int?                           = null,
    @SerializedName("original_language"     ) var originalLanguage    : String?                        = null,
    @SerializedName("overview"              ) var overview            : String?                        = null,
    @SerializedName("poster_path"           ) var posterPath          : String?                        = null,
    @SerializedName("release_date"          ) var releaseDate         : String?                        = null,
    @SerializedName("revenue"               ) var revenue             : Long?                           = null,
    @SerializedName("runtime"               ) var runtime             : Int?                           = null,
    @SerializedName("status"                ) var status              : String?                        = null,
    @SerializedName("tagline"               ) var tagline             : String?                        = null,
    @SerializedName("title"                 ) var title               : String?                        = null,
    @SerializedName("video"                 ) var video               : Boolean?                       = null,
    @SerializedName("vote_average"          ) var voteAverage         : Double?                        = null,
    @SerializedName("vote_count"            ) var voteCount           : Int?                           = null

)
