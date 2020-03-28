package com.github.coraandroidtest.home.business

import com.github.coraandroidtest.base.BaseBusiness
import com.github.coraandroidtest.core.database.dao.ContactDao
import com.github.coraandroidtest.core.database.entity.Contact

class HomeBusiness : BaseBusiness() {

    suspend fun getAllContacts(contactDao: ContactDao): List<Contact> {
        return contactDao.getAllContacts()
    }
}