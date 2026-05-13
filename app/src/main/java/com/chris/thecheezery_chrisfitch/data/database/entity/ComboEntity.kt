package com.chris.thecheezery_chrisfitch.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Combos")
data class ComboEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idCombo")
    val id: Int = 0,

    @ColumnInfo(name = "comboName")
    val name: String,

    @ColumnInfo(name = "comboPrice")
    val price: Float
)