package com.github.coraandroidtest.newcontact.repository

import com.github.coraandroidtest.base.BaseRepository
import com.github.coraandroidtest.core.database.dao.BankDao
import com.github.coraandroidtest.core.database.entity.Bank

class NewContactRepository : BaseRepository() {

    suspend fun getAllBanks(bankDao: BankDao): List<Bank>? {
        return bankDao.getAllBanks()
    }

}