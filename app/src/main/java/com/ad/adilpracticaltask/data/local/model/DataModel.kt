package com.ad.adilpracticaltask.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tasks")
data class DataModel(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val task: String,
    val date: String,
    val time: String,
    val alertNotification: Boolean,
)
