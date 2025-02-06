package com.konstudio.firstaid

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertItem(item: SettingsItem)
    @Query("SELECT * FROM settings")
    fun getAllItem(): Flow<SettingsItem>
    @Query("SELECT * FROM settings WHERE setting = :name")
    fun findByName(name: String): SettingsItem?
    @Update
    fun updateItem(item: SettingsItem)
}