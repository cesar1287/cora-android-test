package com.github.coraandroidtest.home.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.coraandroidtest.base.BaseViewModel
import com.github.coraandroidtest.core.database.CoraDatabase
import com.github.coraandroidtest.core.database.entity.Contact
import com.github.coraandroidtest.home.business.HomeBusiness
import kotlinx.coroutines.launch
import org.koin.core.inject

class HomeViewModel(application: Application) : BaseViewModel(application) {

    private val business: HomeBusiness by inject()

    private val contactDao = CoraDatabase.getDatabase(application).contactDao()

    val contactLiveData: MutableLiveData<Pair<List<Contact>, Int>> = MutableLiveData()

    fun getAllContacts() {
        viewModelScope.launch {
            contactLiveData.postValue(business.getAllContacts(contactDao))
        }
    }

}