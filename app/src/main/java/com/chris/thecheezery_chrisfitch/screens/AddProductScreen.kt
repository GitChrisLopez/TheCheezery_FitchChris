package com.chris.thecheezery_chrisfitch.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chris.thecheezery_chrisfitch.R
import com.chris.thecheezery_chrisfitch.ui.theme.Pinky
import com.chris.thecheezery_chrisfitch.viewmodel.ProductViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chris.thecheezery_chrisfitch.domain.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(
    innerPadding: PaddingValues,
    viewModel: ProductViewModel = viewModel(),
    onNavigateBack: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var priceField by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    var expanded by remember { mutableStateOf(false) }
    val productTypes = listOf("Hot drinks", "Cold drinks", "Salties", "Sweets")
    var selectedType by remember { mutableStateOf(productTypes[0]) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    ) {

        Text(
            "Add a new product",
            color = Pinky,
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(30.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        Spacer(Modifier.height(10.dp))

        OutlinedTextField(
            value = priceField,
            onValueChange = { priceField = it },
            label = { Text("Price") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            trailingIcon = {
                Image(
                    painter = painterResource(R.drawable.money),
                    contentDescription = "dollar icon"
                )
            }
        )

        Spacer(Modifier.height(10.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") }
        )

        Spacer(Modifier.height(25.dp))

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = selectedType,
                onValueChange = {},
                readOnly = true,
                label = { Text("Type") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                productTypes.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            selectedType = selectionOption
                            expanded = false
                        }
                    )
                }
            }
        }

    }
}

/**@Preview(showBackground = true)
@Composable
fun AddProductScreenPreview(){
    AddProductScreen(
        innerPadding = PaddingValues(0.dp),
        viewModel = viewModel()
    )
}**/