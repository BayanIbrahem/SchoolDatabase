package com.training.school_database.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "school")
data class School (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "school_name")
    val name: String,
)