package com.github.coraandroidtest.newcontact.di

import org.koin.core.context.loadKoinModules

object NewContactDependencyInjection {
    private val loadNewContactModules by lazy {
        loadKoinModules(listOf(businessModule, repositoryModule, viewModelModule))
    }

    fun injectModules() = loadNewContactModules
}