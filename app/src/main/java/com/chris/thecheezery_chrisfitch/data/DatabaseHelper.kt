package com.chris.thecheezery_chrisfitch.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.chris.thecheezery_chrisfitch.data.CheezeryContract.ProductsEntry


class DatabaseHelper(context: Context):
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    companion object{
        private const val DATABASE_NAME="cheezery.db"
        private const val DATABASE_VERSION = 2 // esto se debe cambiar q no se me olvide
    }

    // Base de datos
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("PRAGMA foreign_keys = ON") // Permitimos las llaves foraneas en la BD

        // Creamos la tabla
        db.execSQL(
            """CREATE TABLE ${ProductsEntry.TABLE_NAME} (
                    ${ProductsEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
            ${ProductsEntry.COLUMN_NAME} TEXT NOT NULL,
            ${ProductsEntry.COLUMN_IMAGE} TEXT,
            ${ProductsEntry.COLUMN_PRICE} REAL NOT NULL,
            ${ProductsEntry.COLUMN_DESCRIPTION} TEXT,
            ${ProductsEntry.COLUMN_TYPE} TEXT NOT NULL
            )
            """.trimIndent()
        )
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS ${ProductsEntry.TABLE_NAME}")
    }

}