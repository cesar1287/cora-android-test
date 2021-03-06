package com.github.coraandroidtest.newcontact.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.coraandroidtest.base.BaseViewModel
import com.github.coraandroidtest.core.database.entity.Bank
import com.github.coraandroidtest.newcontact.business.NewContactBusiness
import kotlinx.coroutines.launch
import org.koin.core.inject

class NewContactViewModel(application: Application) : BaseViewModel(application) {

    private val business: NewContactBusiness by inject()

    val bankLiveData: MutableLiveData<List<Bank>> = MutableLiveData()
    val mainBankLiveData: MutableLiveData<List<Bank>> = MutableLiveData()

    fun saveNewContactPartially(hashMapField: String, field: Any?) {
        business.saveNewContactPartially(hashMapField, field)
    }

    fun getAllBanks() {
        viewModelScope.launch {
            bankLiveData.postValue(business.getAllBanks())
        }
    }

    fun saveNewContactDatabase() {
        viewModelScope.launch {
            business.saveNewContactDatabase()
        }
    }

    fun getAllMainBanks() {
        viewModelScope.launch {
            mainBankLiveData.postValue(business.getAllMainBanks())
        }
    }
}