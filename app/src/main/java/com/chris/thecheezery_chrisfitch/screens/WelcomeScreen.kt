package com.chris.thecheezery_chrisfitch.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chris.thecheezery_chrisfitch.R
import com.chris.thecheezery_chrisfitch.ui.theme.Brighter_Pink
import com.chris.thecheezery_chrisfitch.ui.theme.Pink40

@Composable
fun WelcomeScreen(onNavigateToMenu: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            painter = painterResource(id = R.drawable.thecheezery),
            contentDescription = "Logo The Cheezery",
            modifier = Modifier
                .fillMaxWidth()
                .height(660.dp),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Pink40),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Welcome to The Cheezery",
                color = Color.White,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(15.dp)
            )

            Text(
                text = "Home of the most wonderful desserts ever seen (and tasted) by the human being",
                color = Color.White,
                fontSize = 14.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(12.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { onNavigateToMenu() },
                colors = ButtonDefaults.buttonColors(containerColor = Brighter_Pink),
                modifier = Modifier
                    .width(130.dp)
                    .padding(bottom = 14.dp)
                    .height(45.dp),
                shape = RoundedCornerShape(25.dp)
            ) {
                Text(
                    text = "Get Started!",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen({})
}