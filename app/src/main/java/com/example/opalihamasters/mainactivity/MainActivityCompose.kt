package com.example.opalihamasters.mainactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.opalihamasters.mainactivity.categorylist.CategoryList
import com.example.opalihamasters.mainactivity.categorylist.CategoryListViewModel
import com.example.opalihamasters.mainactivity.categorylist.di.DaggerCategoryListComponent
import com.example.opalihamasters.mainactivity.di.DaggerMainActivityComponent
import com.example.opalihamasters.mainactivity.main.Main
import com.example.opalihamasters.mainactivity.main.MainViewModel
import com.example.opalihamasters.mainactivity.main.daggerViewModel
import com.example.opalihamasters.mainactivity.main.di.DaggerMainComponent
import com.example.opalihamasters.ui.theme.OpalihaMastersTheme

class MainActivityCompose : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpalihaMastersTheme {
                Root()
            }
        }
    }

    @Composable
    fun Root() {
        val mainActivityComponent = DaggerMainActivityComponent.builder()
            .navHostController(rememberNavController())
            .build()
        NavHost(
            navController = mainActivityComponent.getNavController(),
            startDestination = NavGraph.Main.name
        ) {
            composable(NavGraph.Main.name) {
                Main(
                    viewModel = daggerViewModel {
                        DaggerMainComponent.builder()
                            .mainActivityExternalDependencies(mainActivityComponent)
                            .build()
                            .getViewModel()
                    }
                )
            }
            composable(NavGraph.CategoryList.name) {
                CategoryList(
                    viewModel = daggerViewModel {
                        DaggerCategoryListComponent.builder()
                            .mainActivityExternalDependencies(mainActivityComponent)
                            .build()
                            .getViewModel()
                    }
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ScreenPreview() {
        Main()
    }
}