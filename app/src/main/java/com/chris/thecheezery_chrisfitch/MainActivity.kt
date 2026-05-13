package com.chris.thecheezery_chrisfitch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chris.thecheezery_chrisfitch.data.DatabaseHelper
import com.chris.thecheezery_chrisfitch.data.ProductDAO
import com.chris.thecheezery_chrisfitch.screens.AddProductScreen
import com.chris.thecheezery_chrisfitch.screens.MenuScreen
import com.chris.thecheezery_chrisfitch.screens.ProductsScreen
import com.chris.thecheezery_chrisfitch.screens.WelcomeScreen
import com.chris.thecheezery_chrisfitch.ui.theme.TheCheezery_ChrisFitchTheme
import com.chris.thecheezery_chrisfitch.viewmodel.ProductViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheCheezery_ChrisFitchTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val context = LocalContext.current

                    val dbHelper = DatabaseHelper(context)
                    val dao = ProductDAO(dbHelper)

                    val viewModel: ProductViewModel = viewModel(
                        factory = object : ViewModelProvider.Factory {
                            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                                return ProductViewModel(dao, context) as T
                            }
                        }
                    )

                    NavHost(navController = navController, startDestination = "welcome") {
                        composable("welcome") {
                            WelcomeScreen(
                                onNavigateToMenu = { navController.navigate("menu") }
                            )
                        }

                        composable("menu") {
                            MenuScreen(
                                onCategorySelected = { category ->
                                    navController.navigate("products/$category")
                                },
                                onNavigateToAddProduct = {
                                    navController.navigate("add_product")
                                }
                            )
                        }

                        composable("products/{categoryType}") { backStackEntry ->
                            val categoryType =
                                backStackEntry.arguments?.getString("categoryType") ?: ""

                            LaunchedEffect(categoryType) {
                                viewModel.loadProductsByType(categoryType)
                            }

                            ProductsScreen(
                                categoryType = categoryType,
                                innerPadding = PaddingValues(0.dp),
                                products = viewModel.productsListState
                            )
                        }

                        composable("add_product") {
                            AddProductScreen(
                                innerPadding = PaddingValues(0.dp),
                                viewModel = viewModel,
                                onNavigateBack = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}