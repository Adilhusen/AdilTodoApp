package com.ad.adilpracticaltask.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tasks")
data class DataModel(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val task: String,
    val date: String,
    val dayNumber: String,
    val dayName: String,
    val month: String,
    val time: String,
    var alertNotification: Boolean=true,
    var isCompleted: Boolean=false
)
