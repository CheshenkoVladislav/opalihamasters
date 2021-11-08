package com.example.opalihamasters.mainactivity.categorylist.di

import androidx.navigation.NavHostController
import com.example.opalihamasters.mainactivity.categorylist.CategoryListViewModel
import dagger.Module
import dagger.Provides

@Module
interface CategoryListModule {

    companion object {

        @Provides
        @CategoryList
        fun provideViewModel(navHostController: NavHostController): CategoryListViewModel {
            return CategoryListViewModel(navHostController)
        }
    }
}