package com.example.opalihamasters.mainactivity.categorylist

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class CategoryListViewModel(private val navController: NavController): ViewModel() {

    override fun onCleared() {
        super.onCleared()
        println("CLEAR")
    }
}