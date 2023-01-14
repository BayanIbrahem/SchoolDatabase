package com.training.school_database.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "school")
data class School (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "school_id")
    val id: Long = -1,

    @ColumnInfo(name = "school_name")
    val name: String,
)