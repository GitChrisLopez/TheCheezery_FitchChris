package com.chris.thecheezery_chrisfitch.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chris.thecheezery_chrisfitch.domain.Product
import com.chris.thecheezery_chrisfitch.R
import com.chris.thecheezery_chrisfitch.components.ProductForm


@Composable
fun ProductsScreen(
    categoryType: String,
    innerPadding: PaddingValues,
    products: List<Product>
){
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(Modifier.height(20.dp))

        Text(
            "Products",
            textAlign = TextAlign.Center,
            fontSize = 30.sp
        )

        Spacer(Modifier.height(20.dp))

        LazyColumn(Modifier.fillMaxWidth()) {
            items(products){
                product ->
                ProductItem(product = product)
                /**Row{
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_background),
                        contentDescription = "Imagen de ${product.name}"
                    )
                    Column() {
                        Text("${product.name}")
                        Text("${product.description}")
                    }
                    Text("${product.price}")**/
                }

            }
        }

    }

@Composable
fun ProductItem(product: Product) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.muffin),
            contentDescription = "Imagen de ${product.name}"
        )
        Column(modifier = Modifier.fillMaxWidth(0.7f)) {
            Text("${product.name}")
            Text("${product.description}")
        }
        Text("$${product.price}")
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsScreenPreview(){
    ProductsScreen("",PaddingValues(20.dp),
        products = listOf(Product(1, "latte", 40f,"","","")))
}