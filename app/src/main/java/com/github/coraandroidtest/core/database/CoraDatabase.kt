package com.github.coraandroidtest.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.github.coraandroidtest.core.database.dao.BankDao
import com.github.coraandroidtest.core.database.dao.ContactDao
import com.github.coraandroidtest.core.database.entity.Bank
import com.github.coraandroidtest.core.database.entity.Contact
import com.github.coraandroidtest.core.utils.Database.PREPOPULATE_DATA
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

object CoraDatabase {

    @Volatile private var INSTANCE: CoraTestRoomDatabase? = null

    private var parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.IO

    val scope = CoroutineScope(coroutineContext)

    private fun getInstance(context: Context): CoraTestRoomDatabase =
        INSTANCE ?: synchronized(this) {
            INSTANCE ?: getDatabase(context).also { INSTANCE = it }
        }

    @Database(entities = [Bank::class, Contact::class], version = 1)
    abstract class CoraTestRoomDatabase : RoomDatabase() {
        abstract fun bankDao(): BankDao
        abstract fun contactDao(): ContactDao
    }

    fun getDatabase(context: Context) : CoraTestRoomDatabase {
        return Room.databaseBuilder(
            context,
            CoraTestRoomDatabase::class.java, "cora_db"
        ).addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                scope.launch {
                    getInstance(context).bankDao().insertAllData(PREPOPULATE_DATA)
                }
            }
        }).build()
    }
}