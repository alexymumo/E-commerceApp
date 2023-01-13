package com.example.ecommerce.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ecommerce.data.cache.entity.ProductEntity

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProducts(products: List<ProductEntity>)

    @Query("DELETE FROM product_table")
    suspend fun deleteProducts()

    @Query("SELECT * FROM product_table")
    fun getProducts(): List<ProductEntity>
}