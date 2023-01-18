package com.training.school_database.db.entities.relations

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["student_id", "subject_id"], tableName = "students_cross_subjects")
data class StudentCrossSubject (
    @ColumnInfo(name = "student_id")
    val studentId: Long,

    @ColumnInfo(name = "subject_id")
    val subjectId: Long
)