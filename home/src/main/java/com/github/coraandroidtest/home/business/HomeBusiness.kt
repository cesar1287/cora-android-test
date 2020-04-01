package com.github.coraandroidtest.home.business

import com.github.coraandroidtest.base.BaseBusiness
import com.github.coraandroidtest.core.database.dao.ContactDao
import com.github.coraandroidtest.core.database.entity.Contact
import com.github.coraandroidtest.home.repository.HomeRepository
import org.koin.core.inject

class HomeBusiness : BaseBusiness() {

    private val repository: HomeRepository by inject()

    suspend fun getAllContacts(contactDao: ContactDao): Pair<List<Contact>, Int> {
        val contactsList = repository.getAllContacts(contactDao)
        val lastInsertedContact = repository.getLastInserted(contactDao)

        return Pair(contactsList, lastInsertedContact)
    }
}