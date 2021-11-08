package com.example.opalihamasters.mainactivity.di

import androidx.navigation.NavHostController
import dagger.Component
import javax.inject.Scope

@MainActivity
@Component(dependencies = [NavHostController::class])
interface MainActivityComponent: MainActivityExternalDependencies {

}

interface MainActivityExternalDependencies {

    fun getNavController(): NavHostController
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class MainActivity