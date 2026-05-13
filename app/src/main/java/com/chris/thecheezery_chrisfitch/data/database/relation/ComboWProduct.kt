package com.chris.thecheezery_chrisfitch.data.database.relation

import androidx.room.Relation
import androidx.room.Embedded
import androidx.room.Junction
import com.chris.thecheezery_chrisfitch.data.database.entity.ProductEntity
import com.chris.thecheezery_chrisfitch.data.database.entity.ComboEntity
import com.chris.thecheezery_chrisfitch.data.database.entity.ProductComboEntity

data class ComboWProduct(
    @Embedded
    val combo: ComboEntity,

    @Relation(
        parentColumn = "idCombo",
        entityColumn = "productId",
        associateBy = Junction(
            value = ProductComboEntity::class,
            parentColumn = "idCombo",
            entityColumn = "productId"
        )
    )
    val product: List<ProductEntity>
)