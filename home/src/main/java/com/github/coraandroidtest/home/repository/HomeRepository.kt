package com.github.coraandroidtest.home.repository

import com.github.coraandroidtest.core.database.dao.ContactDao
import com.github.coraandroidtest.core.database.entity.Contact

class HomeRepository {

    suspend fun getAllContacts(contactDao: ContactDao): List<Contact> {
        return contactDao.getAllContacts()
    }

    suspend fun getLastInserted(contactDao: ContactDao): Int {
        return contactDao.getLastInserted()
    }

}