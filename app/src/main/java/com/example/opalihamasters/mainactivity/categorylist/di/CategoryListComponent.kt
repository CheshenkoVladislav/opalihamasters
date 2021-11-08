package com.example.opalihamasters.mainactivity.categorylist.di

import com.example.opalihamasters.mainactivity.categorylist.CategoryListViewModel
import com.example.opalihamasters.mainactivity.di.MainActivityExternalDependencies
import dagger.Component
import javax.inject.Scope

@CategoryList
@Component(
    dependencies = [MainActivityExternalDependencies::class],
    modules = [CategoryListModule::class]
)
interface CategoryListComponent {

    fun getViewModel(): CategoryListViewModel
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class CategoryList