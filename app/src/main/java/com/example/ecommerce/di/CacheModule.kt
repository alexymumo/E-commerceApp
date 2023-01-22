package com.example.ecommerce.di

import android.content.Context
import androidx.room.Room
import com.example.ecommerce.data.cache.dao.FavoriteDao
import com.example.ecommerce.data.cache.database.AppDatabase
import com.example.ecommerce.data.cache.database.FavoriteDatabase
import com.example.ecommerce.data.cache.typeconverter.RatingConverter
import com.example.ecommerce.data.repository.FavoriteRepositoryImpl
import com.example.ecommerce.domain.repository.FavoriteRepository
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    /*
    @Provides
    @Singleton
    fun provideConverters(gson: Gson) = RatingConverter(gson)
     */

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "app.db"
        ).fallbackToDestructiveMigration().build()
    }
    /*

    @Provides
    @Singleton
    fun providesFavoriteDatabase(@ApplicationContext appContext: Context, rateConverter: RatingConverter): FavoriteDatabase {
        return Room.databaseBuilder(
            appContext,
            FavoriteDatabase::class.java,
            "favorite.db"
        ).fallbackToDestructiveMigration().addTypeConverter(rateConverter).build()
    }
    @Provides
    @Singleton
    fun providesFavoriteRepository(favoriteDatabase: FavoriteDatabase): FavoriteRepository {
        return FavoriteRepositoryImpl(favoriteDatabase.favoriteDao)
    }
     */
}