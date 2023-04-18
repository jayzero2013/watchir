package com.jehubasa.watchir.dataClass

import com.google.gson.annotations.SerializedName

data class GenresData (

    @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null

)
