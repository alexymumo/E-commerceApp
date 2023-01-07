package com.example.ecommerce.data.cache.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.example.ecommerce.data.cache.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Insert(onConflict = IGNORE)
    suspend fun saveProduct(favoriteEntity: FavoriteEntity)

    @Query("SELECT * FROM product_table")
    fun getAllProducts() : Flow<List<FavoriteEntity>>

    @Delete
    suspend fun deleteFavorite(favoriteEntity: FavoriteEntity)
}