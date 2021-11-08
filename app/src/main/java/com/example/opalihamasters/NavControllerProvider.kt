package com.example.opalihamasters

interface NavControllerProvider {

    fun getNavController(): String
}

class NavControllerProviderImpl: NavControllerProvider {

    override fun getNavController(): String = "dsadas"
}