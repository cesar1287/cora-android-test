package com.github.coraandroidtest.newcontact.repository

import com.github.coraandroidtest.base.BaseRepository
import com.github.coraandroidtest.core.database.dao.BankDao
import com.github.coraandroidtest.core.database.dao.ContactDao
import com.github.coraandroidtest.core.database.entity.Bank
import com.github.coraandroidtest.core.database.entity.Contact

class NewContactRepository : BaseRepository() {

    suspend fun getAllBanks(
        bankDao: BankDao
    ): List<Bank>? {
        return bankDao.getAllBanks()
    }

    suspend fun saveNewContact(
        contactDao: ContactDao,
        contact: Contact
    ) {
        contactDao.insert(contact)
    }

}