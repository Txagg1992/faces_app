package com.curiousapps.smileyfaces.network

import com.curiousapps.smileyfaces.domain.FaceItems
import com.curiousapps.smileyfaces.util.URL_EXT
import com.curiousapps.smileyfaces.util.URL_ONE
import retrofit2.http.GET
import retrofit2.http.Path

interface FaceApi {

    @GET(URL_EXT)
    suspend fun fetchAllFaces(): List<FaceItems>

    @GET(URL_ONE)
    suspend fun fetchOneFace(
        @Path("slug") slug: String
    ): List<FaceItems>
}