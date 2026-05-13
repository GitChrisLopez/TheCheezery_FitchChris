package com.chris.thecheezery_chrisfitch.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chris.thecheezery_chrisfitch.R
import com.chris.thecheezery_chrisfitch.ui.theme.Brighter_Pink
import com.chris.thecheezery_chrisfitch.ui.theme.*

@Composable
fun MenuScreen(
    onCategorySelected: (String) -> Unit,
    onNavigateToAddProduct: () -> Unit)
{

    val firstGradient = Brush.verticalGradient(listOf(Brighter_Pink, Pinky))
    val secondGradient = Brush.verticalGradient(listOf(Pinky, Less_Purple))
    val thirdGradient = Brush.verticalGradient(listOf(Less_Purple, Very_purple))


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.grupo_2),
            contentDescription = "Logo The Cheezery",
            modifier = Modifier
                .width(300.dp)
                .padding(12.dp),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 6.dp)
            ) {

                Options("Hot drinks", firstGradient) { onCategorySelected("Hot drinks") }
                Options("Salties", secondGradient) { onCategorySelected("Salties") }
                Options("Combos", thirdGradient) { /*nose*/ }

            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 6.dp)
            ) {

                Options("Cold drinks", firstGradient) { onCategorySelected("Cold drinks") }
                Options("Sweets", secondGradient) { onCategorySelected("Sweets") }
                Options("Add new product", thirdGradient) { onNavigateToAddProduct() }

            }

        }
    }
}

@Composable
fun Options(text: String, gradient: Brush, onClick: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 1.dp)
            .background(brush = gradient)
            .clickable { onClick() }
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = text,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview(){
    MenuScreen({}, {})
}