package com.training.school_database.db.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.training.school_database.db.entities.Student
import com.training.school_database.db.entities.Subject

data class SubjectWithStudents (
    @Embedded val subject: Subject,
    @Relation (
        parentColumn = "subject_id",
        entityColumn = "student_id",
        associateBy = Junction(StudentsCrossSubjects::class)
    )
    val students: List<Student>
)