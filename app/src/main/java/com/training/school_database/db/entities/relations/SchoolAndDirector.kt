package com.training.school_database.db.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.training.school_database.db.entities.Director
import com.training.school_database.db.entities.School

data class SchoolAndDirector (
    @Embedded val school: School,
    @Relation (
        parentColumn = "school_id", // in school table
        entityColumn = "school_id"  // in director table
    )
    val director: Director
)