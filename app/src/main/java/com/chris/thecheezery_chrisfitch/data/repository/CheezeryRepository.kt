package com.chris.thecheezery_chrisfitch.data.repository

import com.chris.thecheezery_chrisfitch.data.database.AppDatabase
import com.chris.thecheezery_chrisfitch.data.database.entity.ComboEntity
import com.chris.thecheezery_chrisfitch.data.database.entity.ProductComboEntity
import com.chris.thecheezery_chrisfitch.data.database.entity.ProductEntity
import com.chris.thecheezery_chrisfitch.data.database.relation.ComboWProduct
import kotlinx.coroutines.flow.Flow

class CheezeryRepository (private val database: AppDatabase) {
    private val productDao = database.productDao()
    private val comboDao = database.comboDao()
    private val productComboDao = database.productComboDao()

    suspend fun insertProduct(product: ProductEntity): Long {
        return productDao.insertProduct(product)
    }

    fun getAllProducts(): Flow<List<ProductEntity>> {
        return productDao.getAllProducts()
    }

    suspend fun getProductById(id: Int): ProductEntity? {
        return productDao.getProductById(id)
    }

    suspend fun insertCombo(combo: ComboEntity): Long {
        return comboDao.insertCombo(combo)
    }

    fun getCombosWithProducts(): Flow<List<ComboWProduct>> {
        return comboDao.getCombosWithProducts()
    }

    suspend fun insertProductCombo(relation: ProductComboEntity) {
        productComboDao.insertProductCombo(relation)
    }
}