package com.github.coraandroidtest.home.di

import com.github.coraandroidtest.core.database.CoraDatabase
import com.github.coraandroidtest.home.business.HomeBusiness
import com.github.coraandroidtest.home.repository.HomeRepository
import com.github.coraandroidtest.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val parameters = module {
    single { CoraDatabase.getDatabase(get()).bankDao() }
    single { CoraDatabase.getDatabase(get()).contactDao() }
}

val businessModule = module {
    single { HomeBusiness() }
}

val repositoryModule = module {
    single { HomeRepository() }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}