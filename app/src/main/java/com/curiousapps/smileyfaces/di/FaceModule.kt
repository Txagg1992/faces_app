package com.curiousapps.smileyfaces.di

import com.curiousapps.smileyfaces.data.FaceRepositoryImpl
import com.curiousapps.smileyfaces.domain.FaceRepository
import com.curiousapps.smileyfaces.network.FaceApi
import com.curiousapps.smileyfaces.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FaceModule {

    @Provides
    @Singleton
    fun provideApi(): FaceApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FaceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFaceRepository(
        api: FaceApi
    ): FaceRepository = FaceRepositoryImpl(api = api)
}