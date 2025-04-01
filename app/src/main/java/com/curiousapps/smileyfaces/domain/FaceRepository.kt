package com.curiousapps.smileyfaces.domain

import dagger.hilt.android.scopes.ActivityScoped

@ActivityScoped
interface FaceRepository {

    suspend fun fetchAllFaces(): Result<List<FaceItems>>
    suspend fun fetchOneFace(slug: String): Result<List<FaceItems>>

}