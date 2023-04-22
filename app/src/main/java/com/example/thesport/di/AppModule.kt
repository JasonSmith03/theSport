package com.example.thesport.di

import android.content.Context
import android.content.SharedPreferences
import com.example.thesport.data.remote.SportApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPrefs(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("prefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideSportApi(): SportApi {
        return Retrofit.Builder()
            .baseUrl(SportApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }
}