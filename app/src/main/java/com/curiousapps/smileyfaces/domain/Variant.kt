package com.curiousapps.smileyfaces.domain


import com.google.gson.annotations.SerializedName

data class Variant(
    @SerializedName("character")
    var character: String,
    @SerializedName("slug")
    var slug: String
)