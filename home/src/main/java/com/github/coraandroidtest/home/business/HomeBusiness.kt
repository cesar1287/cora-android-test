package com.github.coraandroidtest.home.business

import com.github.coraandroidtest.base.BaseBusiness
import com.github.coraandroidtest.core.database.dao.ContactDao
import com.github.coraandroidtest.core.database.entity.Contact
import com.github.coraandroidtest.home.repository.HomeRepository
import org.koin.core.inject

class HomeBusiness : BaseBusiness() {

    private val repository: HomeRepository by inject()

    suspend fun getAllContacts(contactDao: ContactDao): List<Contact> {
        return repository.getAllContacts(contactDao)
    }
}