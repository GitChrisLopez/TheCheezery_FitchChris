package com.chris.thecheezery_chrisfitch.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chris.thecheezery_chrisfitch.data.DatabaseHelper
import com.chris.thecheezery_chrisfitch.data.ProductDAO
import com.chris.thecheezery_chrisfitch.domain.Product
import kotlinx.coroutines.launch

class ProductViewModel ( private val dao: ProductDAO, private val context: Context ): ViewModel()
{
    var productsListState by mutableStateOf( value = listOf<Product>())

    init {
        viewModelScope.launch {
            getAllProducts()
        }
    }

    fun saveProduct(product: Product){
        val newProduct = dao.insertProduct(product)
        if (newProduct != -1L){
            Toast.makeText(
                context,
                "Producto guardado",
                Toast.LENGTH_SHORT).show()
            getAllProducts()
        }else{
            Toast.makeText(
                context,
                "Hubo un error al guardar",
                Toast.LENGTH_SHORT).show()
        }
    }

    fun loadProductsByType(type: String){
        productsListState = dao.getProductsByType(type)
    }

    fun getAllProducts(){
        productsListState = dao.getAllProducts()
    }

}