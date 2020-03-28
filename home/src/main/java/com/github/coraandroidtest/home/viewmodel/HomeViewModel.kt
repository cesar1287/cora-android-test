package com.github.coraandroidtest.home.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.coraandroidtest.base.BaseViewModel
import com.github.coraandroidtest.core.database.CoraDatabase
import com.github.coraandroidtest.core.database.entity.Bank
import com.github.coraandroidtest.core.database.entity.Contact
import com.github.coraandroidtest.home.business.HomeBusiness
import kotlinx.coroutines.launch
import org.koin.core.inject

class HomeViewModel(application: Application) : BaseViewModel(application) {

    private val business: HomeBusiness by inject()

    private val contactDao = CoraDatabase.getDatabase(application).contactDao()

    val bankLiveData: MutableLiveData<List<Contact>> = MutableLiveData()

    fun getAllContacts() {
        viewModelScope.launch {
            bankLiveData.postValue(business.getAllContacts(contactDao))
        }
    }

}