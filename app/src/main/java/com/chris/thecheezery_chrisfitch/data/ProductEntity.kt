package com.chris.thecheezery_chrisfitch.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "productId")
    val id: Int= 0,

    @ColumnInfo(name = "productName")
    val name: String,

    @ColumnInfo(name = "productPrice")
    val price: Float,

    @ColumnInfo(name = "productImage")
    val image: String? = null
)