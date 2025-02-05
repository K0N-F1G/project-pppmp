package com.konstudio.firstaid

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "settings")
data class SettingsItem (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "setting")
    var setting: String,
    @ColumnInfo(name = "value")
    var value: String
)
