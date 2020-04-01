package com.github.coraandroidtest.newcontact.business

import com.github.coraandroidtest.base.BaseBusiness
import com.github.coraandroidtest.core.database.dao.BankDao
import com.github.coraandroidtest.core.database.dao.ContactDao
import com.github.coraandroidtest.core.database.entity.Bank
import com.github.coraandroidtest.core.database.entity.Contact
import com.github.coraandroidtest.core.utils.CoraHelper
import com.github.coraandroidtest.core.utils.NewContact.HASH_MAP_ACCOUNT
import com.github.coraandroidtest.core.utils.NewContact.HASH_MAP_AGENCY
import com.github.coraandroidtest.core.utils.NewContact.HASH_MAP_BANK
import com.github.coraandroidtest.core.utils.NewContact.HASH_MAP_CPF
import com.github.coraandroidtest.core.utils.NewContact.HASH_MAP_NAME
import com.github.coraandroidtest.newcontact.repository.NewContactRepository
import org.koin.core.inject

class NewContactBusiness: BaseBusiness() {

    private val repository: NewContactRepository by inject()

    fun saveNewContactPartially(hashMapField: String, field: Any?) {
        CoraHelper.insertFieldNewContact(hashMapField, field)
    }

    suspend fun getAllBanks(): List<Bank>? {
        return repository.getAllBanks()
    }

    suspend fun saveNewContactDatabase() {
        val getContact = CoraHelper.getUserSavedPartially()
        val contact = Contact(
            contactName = getContact[HASH_MAP_NAME] as? String,
            contactCpf = getContact[HASH_MAP_CPF] as? String,
            contactBankCode = getContact[HASH_MAP_BANK] as? Int,
            contactAgency = getContact[HASH_MAP_AGENCY] as? String,
            contactAccount = getContact[HASH_MAP_ACCOUNT] as? String
        )

        repository.saveNewContact(contact)
    }

    suspend fun getAllMainBanks(): List<Bank>? {
        return repository.getAllMainBanks()
    }

}