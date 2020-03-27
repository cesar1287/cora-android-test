package com.github.coraandroidtest.core.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "contact_name") val contactName: String?,
    @ColumnInfo(name = "contact_cpf") val contactCpf: String?,
    @ColumnInfo(name = "contact_agency") val contactAgency: String?,
    @ColumnInfo(name = "contact_account") val contactAccount: String?
) : Parcelable