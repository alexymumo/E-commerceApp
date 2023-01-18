package com.example.ecommerce.data.cache.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.example.ecommerce.data.cache.entity.FavoriteEntity

@Dao
interface FavoriteDao {
    @Insert(onConflict = IGNORE)
    suspend fun saveProduct(favoriteEntity: FavoriteEntity)

    @Query("SELECT * FROM favorite_table ORDER BY id DESC")
    fun getProducts() : LiveData<List<FavoriteEntity>>

    @Query("SELECT `favorite` FROM favorite_table WHERE id == :id")
    fun isFavorite(id: Int): LiveData<Boolean>

    @Delete
    suspend fun deleteFavorite(favoriteEntity: FavoriteEntity)
}