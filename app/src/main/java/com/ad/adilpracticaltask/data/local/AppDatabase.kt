package com.ad.adilpracticaltask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ad.adilpracticaltask.data.local.AppDao
import com.ad.adilpracticaltask.data.local.model.DataModel

@Database(entities = [DataModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): AppDao
}
