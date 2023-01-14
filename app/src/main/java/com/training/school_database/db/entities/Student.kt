package com.training.school_database.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    val id: Long = -1,

    @ColumnInfo(name = "student_name")
    val name: String,

    @ColumnInfo(name = "student_semester")
    val semester: Int,

    @ColumnInfo(name = "school_name")
    val schoolName: String
)