package com.github.coraandroidtest.core.database.dao

import androidx.room.*
import com.github.coraandroidtest.core.database.entity.Bank
import com.github.coraandroidtest.core.database.entity.Contact

@Dao
interface ContactDao {

    @Query("SELECT * FROM contacts")
    suspend fun getAllContacts(): List<Contact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contact: Contact)
}