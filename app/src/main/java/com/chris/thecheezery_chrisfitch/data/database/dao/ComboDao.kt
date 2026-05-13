package com.chris.thecheezery_chrisfitch.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.chris.thecheezery_chrisfitch.data.database.entity.ComboEntity
import com.chris.thecheezery_chrisfitch.data.database.relation.ComboWProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface ComboDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCombo(combo: ComboEntity): Long

    @Update
    suspend fun updateCombo(combo: ComboEntity)

    @Delete
    suspend fun deleteCombo(combo: ComboEntity)

    @Query("SELECT * FROM Combos")
    fun getAllCombos(): Flow<List<ComboEntity>>

    @Query("SELECT * FROM Combos WHERE idCombo = :idCombo")
    suspend fun getComboById(idCombo: Int): ComboEntity?

    @Transaction
    @Query("SELECT * FROM Combos")
    fun getCombosWithProducts(): Flow<List<ComboWProduct>>

    @Transaction
    @Query("SELECT * FROM Combos WHERE idCombo = :idCombo")
    suspend fun getComboWithProductsById(idCombo: Int): ComboWProduct?
}