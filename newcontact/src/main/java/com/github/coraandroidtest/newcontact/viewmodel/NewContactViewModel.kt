package com.github.coraandroidtest.newcontact.viewmodel

import android.app.Application
import com.github.coraandroidtest.base.BaseViewModel
import com.github.coraandroidtest.newcontact.business.NewContactBusiness
import org.koin.core.inject

class NewContactViewModel(application: Application) : BaseViewModel(application) {

    private val business: NewContactBusiness by inject()

    fun saveNewContactPartially(hashMapField: String, field: String) {
        business.saveNewContactPartially(hashMapField, field)
    }
}