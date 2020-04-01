package com.github.coraandroidtest.home.repository

import com.github.coraandroidtest.base.BaseRepository
import com.github.coraandroidtest.core.database.dao.BankDao
import com.github.coraandroidtest.core.database.dao.ContactDao
import com.github.coraandroidtest.core.database.entity.Contact

class HomeRepository(
    private val contactDao: ContactDao
) : BaseRepository() {

    suspend fun getAllContacts(): List<Contact> {
        return contactDao.getAllContacts()
    }

    suspend fun getLastInserted(): Int? {
        return contactDao.getLastInserted()
    }

}