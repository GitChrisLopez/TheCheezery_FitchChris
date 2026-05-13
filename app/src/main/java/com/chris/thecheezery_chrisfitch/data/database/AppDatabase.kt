package com.chris.thecheezery_chrisfitch.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.chris.thecheezery_chrisfitch.data.database.dao.ComboDao
import com.chris.thecheezery_chrisfitch.data.database.dao.ProductComboDao
import com.chris.thecheezery_chrisfitch.data.database.dao.ProductDao
import com.chris.thecheezery_chrisfitch.data.database.entity.ProductEntity
import com.chris.thecheezery_chrisfitch.data.database.entity.ComboEntity
import com.chris.thecheezery_chrisfitch.data.database.entity.ProductComboEntity

@Database(
    entities = [
        ProductEntity::class,
        ComboEntity::class,
        ProductComboEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun comboDao(): ComboDao
    abstract fun productComboDao(): ProductComboDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cheezery.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}