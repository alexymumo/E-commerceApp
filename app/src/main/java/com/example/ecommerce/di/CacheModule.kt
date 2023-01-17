package com.example.ecommerce.di

import android.content.Context
import androidx.room.Room
import com.example.ecommerce.data.cache.dao.FavoriteDao
import com.example.ecommerce.data.cache.database.AppDatabase
import com.example.ecommerce.data.repository.FavoriteRepository
import com.example.ecommerce.data.repository.FavoriteRepositoryImpl
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
        ).fallbackToDestructiveMigration().build()


    }

    @Provides
    @Singleton
    fun providesRepository(appDatabase: AppDatabase): FavoriteRepository {
        return FavoriteRepositoryImpl(appDatabase.favoriteDao)
    }

    /*
    @Provides
    @Singleton
    fun providesDao(appDatabase: AppDatabase): FavoriteDao {
        return appDatabase.favoriteDao()
    }

     */
}