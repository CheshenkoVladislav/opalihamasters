package com.example.opalihamasters.mainactivity.main.di

import androidx.navigation.NavHostController
import com.example.opalihamasters.mainactivity.main.MainViewModel
import dagger.Module
import dagger.Provides

@Module
interface MainModule {

    companion object {

        @Provides
        @Main
        fun provideViewModel(navController: NavHostController): MainViewModel {
            return MainViewModel(navController)
        }
    }
}