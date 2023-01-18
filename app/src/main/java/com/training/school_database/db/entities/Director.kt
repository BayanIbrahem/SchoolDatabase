package com.training.school_database.db.entities

import androidx.annotation.IntDef
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "director")
data class Director (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "director_id")
    val id: Long? = null,

    @ColumnInfo(name = "director_name", defaultValue = "director-:id" )
    val name: String,

    @ColumnInfo(name = "school_name")
    val schoolName: String
) {
    val noId: Director
        get() = this@Director.copy(id = null)
}