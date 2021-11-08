package com.example.opalihamasters.mainactivity.main

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.opalihamasters.mainactivity.NavGraph

class MainViewModel(private val navController: NavController) : ViewModel() {

    fun onClickServices() {
        navController.navigate(NavGraph.CategoryList.name)
    }

    fun onClickProfile() {

    }
}