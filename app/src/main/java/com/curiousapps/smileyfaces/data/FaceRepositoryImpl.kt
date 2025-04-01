package com.curiousapps.smileyfaces.data

import com.curiousapps.smileyfaces.domain.FaceItems
import com.curiousapps.smileyfaces.domain.FaceRepository
import com.curiousapps.smileyfaces.network.FaceApi
import okio.IOException
import javax.inject.Inject

class FaceRepositoryImpl @Inject constructor(
    private val api: FaceApi
): FaceRepository {
    override suspend fun fetchAllFaces(): Result<List<FaceItems>> {
        try {
            api.fetchAllFaces().let {
                return Result.success(it)
            }
        }catch (e: IOException){
            return Result.failure(e)
        }
    }

    override suspend fun fetchOneFace(slug: String): Result<List<FaceItems>> {
        try {
            api.fetchOneFace(slug).let {
                return Result.success(it)
            }
        }catch (e: IOException){
            return Result.failure(e)
        }
    }
}