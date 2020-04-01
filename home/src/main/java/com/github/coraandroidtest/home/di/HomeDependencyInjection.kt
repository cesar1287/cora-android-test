package com.github.coraandroidtest.home.di

import org.koin.core.context.loadKoinModules

object HomeDependencyInjection {
    private val loadHomeModules by lazy {
        loadKoinModules(listOf(parameters, businessModule, repositoryModule, viewModelModule))
    }

    fun injectModules() = loadHomeModules
}