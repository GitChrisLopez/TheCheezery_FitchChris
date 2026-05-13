package com.chris.thecheezery_chrisfitch.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.chris.thecheezery_chrisfitch.data.database.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: ProductEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(product: List<ProductEntity>)

    @Update
    suspend fun updateProduct(product: ProductEntity)

    @Delete
    suspend fun deleteProduct(product: ProductEntity)

    @Query("SELECT * FROM Products")
    fun getAllProducts(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM Products WHERE productId = :idProduct")
    suspend fun getProductById(idProduct: Int): ProductEntity?

    @Query ("SELECT * FROM Products WHERE productName LIKE '%' || :name || '%'")
    fun searchProducts(name: String): Flow<List<ProductEntity>>
}