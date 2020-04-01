package com.github.coraandroidtest.newcontact.di

import com.github.coraandroidtest.newcontact.business.NewContactBusiness
import com.github.coraandroidtest.newcontact.repository.NewContactRepository
import com.github.coraandroidtest.newcontact.viewmodel.NewContactViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val businessModule = module {
    single { NewContactBusiness() }
}

val repositoryModule = module {
    single { NewContactRepository(get(), get()) }
}

val viewModelModule = module {
    viewModel { NewContactViewModel(get()) }
}