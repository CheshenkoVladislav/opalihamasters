package com.example.opalihamasters.mainactivity

sealed class NavGraph(val name: String) {
    object Main: NavGraph(name = "main")
    object CategoryList: NavGraph(name = "categoryList")
}

