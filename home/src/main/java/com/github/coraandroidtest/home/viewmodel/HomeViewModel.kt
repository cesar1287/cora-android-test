package com.github.coraandroidtest.home.viewmodel

import com.github.coraandroidtest.base.BaseViewModel
import com.github.coraandroidtest.home.business.HomeBusiness
import org.koin.core.inject

class HomeViewModel : BaseViewModel() {

    private val business: HomeBusiness by inject()

    fun getAllContacts() {

    }

}