package com.training.school_database.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "director")
data class Director (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "director_id")
    val id: Long = -1,

    @ColumnInfo(name = "director_name", defaultValue = "director-:id" )
    val name: String,

    @ColumnInfo(name = "school_id")
    val schoolId: Long = -1
)