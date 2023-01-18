package com.training.school_database.db.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.training.school_database.db.entities.Student
import com.training.school_database.db.entities.Subject

data class StudentsWithSubjects (
    @Embedded val student: Student,
    @Relation(
        parentColumn = "student_id",
        entityColumn = "subject_id",
        associateBy = Junction(StudentCrossSubject::class)
    )
    val subjects: List<Subject>
)