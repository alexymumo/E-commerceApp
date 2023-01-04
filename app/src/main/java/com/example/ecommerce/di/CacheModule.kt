package com.example.ecommerce.di

import android.content.Context
import androidx.room.Room
import com.example.ecommerce.data.cache.dao.FavoriteDao
import com.example.ecommerce.data.cache.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object CacheModule {

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext appContext: Context): AppDatabase {

        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "app.db"
        ).build()

    }

    @Provides
    @Singleton
    fun providesDao(appDatabase: AppDatabase): FavoriteDao {
        return appDatabase.favoriteDao()
    }
}