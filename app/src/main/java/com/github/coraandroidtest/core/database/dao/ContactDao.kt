package com.github.coraandroidtest.core.database.dao

import androidx.room.*
import com.github.coraandroidtest.core.database.entity.Bank
import com.github.coraandroidtest.core.database.entity.Contact

@Dao
interface ContactDao {

    @Query("SELECT * FROM contacts ORDER BY contact_name ASC")
    suspend fun getAllContacts(): List<Contact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contact: Contact)

    @Query("SELECT max(uid) from contacts")
    suspend fun getLastInserted(): Int
}