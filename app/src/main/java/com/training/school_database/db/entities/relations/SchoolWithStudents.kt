package com.training.school_database.db.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.training.school_database.db.entities.School
import com.training.school_database.db.entities.Student

data class SchoolWithStudents (
    @Embedded val school: School,
    @Relation(
        parentColumn = "school_name", // from school table
        entityColumn = "school_name", // from student table
    )
    val students: List<Student>
)