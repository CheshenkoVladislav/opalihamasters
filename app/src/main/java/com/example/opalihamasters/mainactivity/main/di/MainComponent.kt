package com.example.opalihamasters.mainactivity.main.di

import com.example.opalihamasters.mainactivity.di.MainActivityExternalDependencies
import com.example.opalihamasters.mainactivity.main.MainViewModel
import dagger.Component
import javax.inject.Scope

@Main
@Component(dependencies = [MainActivityExternalDependencies::class], modules = [MainModule::class])
interface MainComponent {

    fun getViewModel(): MainViewModel
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class Main