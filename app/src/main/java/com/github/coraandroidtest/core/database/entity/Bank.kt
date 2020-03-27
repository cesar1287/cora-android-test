package com.github.coraandroidtest.core.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "banks")
data class Bank(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "bank_name") val bankName: String?,
    @ColumnInfo(name = "bank_code") val bankCode: Int?,
    @ColumnInfo(name = "bank_main") val bankMain: Boolean = false
) : Parcelable