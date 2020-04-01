package com.github.coraandroidtest.core.database.dao

import androidx.room.*
import com.github.coraandroidtest.core.database.entity.Bank

@Dao
interface BankDao {

    @Query("SELECT * FROM banks")
    suspend fun getAllBanks(): List<Bank>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllData(banksList: List<Bank>)

    @Query("SELECT * FROM banks where bank_main == 1")
    suspend fun getAllMainBanks(): List<Bank>
}