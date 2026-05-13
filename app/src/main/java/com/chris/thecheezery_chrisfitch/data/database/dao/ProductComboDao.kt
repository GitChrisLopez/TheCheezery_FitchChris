package com.chris.thecheezery_chrisfitch.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chris.thecheezery_chrisfitch.data.database.entity.ProductComboEntity

@Dao
interface ProductComboDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductCombo(productCombo: ProductComboEntity): Long

    @Delete
    suspend fun deleteProductCombo(productCombo: ProductComboEntity)

    @Query("DELETE FROM ProductsCombo WHERE idCombo = :idCombo AND idProduct = :idProduct")
    suspend fun deleteRelation(idCombo: Int, idProduct: Int)
}