package com.training.school_database.db.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.training.school_database.db.entities.Director
import com.training.school_database.db.entities.School

data class SchoolAndDirector (
    @Embedded val school: School,
    @Relation (
        parentColumn = "school_name", // in school table
        entityColumn = "school_name"  // in director table
    )
    val director: Director
)