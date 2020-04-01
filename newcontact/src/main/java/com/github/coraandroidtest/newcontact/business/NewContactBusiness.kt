package com.github.coraandroidtest.newcontact.business

import com.github.coraandroidtest.base.BaseBusiness
import com.github.coraandroidtest.core.database.dao.BankDao
import com.github.coraandroidtest.core.database.entity.Bank
import com.github.coraandroidtest.newcontact.repository.NewContactRepository
import org.koin.core.inject

class NewContactBusiness: BaseBusiness() {

    private val repository: NewContactRepository by inject()

    fun saveNewContactPartially(hashMapField: String, field: Any?) {

    }

    suspend fun getAllBanks(bankDao: BankDao): List<Bank>? {
        return repository.getAllBanks(bankDao)
    }

}