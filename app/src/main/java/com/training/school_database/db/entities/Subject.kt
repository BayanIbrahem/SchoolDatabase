package com.training.school_database.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subject")
data class Subject (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "subject_id")
    val id: Long? = null,

    @ColumnInfo(name = "subject_name")
    val name: String
) {
    val noId: Subject
    get() = this@Subject.copy(id = null)
}