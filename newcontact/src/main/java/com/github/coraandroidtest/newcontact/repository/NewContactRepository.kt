package com.github.coraandroidtest.newcontact.repository

import com.github.coraandroidtest.base.BaseRepository
import com.github.coraandroidtest.core.database.dao.BankDao
import com.github.coraandroidtest.core.database.dao.ContactDao
import com.github.coraandroidtest.core.database.entity.Bank
import com.github.coraandroidtest.core.database.entity.Contact

class NewContactRepository(
    private val contactDao: ContactDao,
    private val bankDao: BankDao
) : BaseRepository() {

    suspend fun getAllBanks(): List<Bank>? {
        return bankDao.getAllBanks()
    }

    suspend fun saveNewContact(
        contact: Contact
    ) {
        contactDao.insert(contact)
    }

    suspend fun getAllMainBanks(): List<Bank>? {
        return bankDao.getAllMainBanks()
    }

}