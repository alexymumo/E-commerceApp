package com.example.ecommerce.data.cache.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.ecommerce.data.cache.database.AppDatabase
import com.example.ecommerce.data.cache.entity.FavoriteEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(AndroidJUnit4::class)
class FavoriteDaoTest {
    private lateinit var appDatabase: AppDatabase
    private lateinit var favoriteDao: FavoriteDao

    @Before
    fun setUpDatabase() {
        appDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        favoriteDao = appDatabase.favoriteDao
    }

    @After
    fun closeDatabase() {
        appDatabase.close()
    }

    @Test
    fun testInsertFavorite() = runBlocking {
        val favorite = FavoriteEntity(
            1,
            "new",
            "23",
            "image",
            23.3,
            "Watch",
            true
        )
        favoriteDao.saveProduct(favorite)
        val favorites = favoriteDao.getProducts()
        //                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      assertThat(favorites.value!!.contains(favorite)).isFalse()
    }

    @Test
    fun deleteProductTest() = runBlocking {

    }
}