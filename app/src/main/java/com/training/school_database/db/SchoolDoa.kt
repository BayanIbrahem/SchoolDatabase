package com.training.school_database.db

import androidx.room.*
import com.training.school_database.db.entities.Director
import com.training.school_database.db.entities.School
import com.training.school_database.db.entities.Student
import com.training.school_database.db.entities.Subject
import com.training.school_database.db.entities.relations.*

@Dao
interface SchoolDoa {
    /** insert: */
    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = School::class)
    suspend fun insertSchool(school: School): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = Director::class)
    suspend fun insertDirector(director: Director): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = Student::class)
    suspend fun insertStudent(student: Student): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = Subject::class)
    suspend fun insertSubject(subject: Subject): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = StudentsCrossSubjects::class)
    suspend fun insertStudentCrossSubject(crossRef: StudentsCrossSubjects): Long

    /** select: */
    @Transaction // multi threads safety.
    @Query("SELECT * FROM school WHERE school_name = :schoolName")
    suspend fun getSchoolAndDirector(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE school_name = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM students_cross_subjects, student WHERE students_cross_subjects.student_id = :studentId AND student.student_id = :studentId")
    suspend fun getStudentWithSubjects(studentId: Long): List<StudentsWithSubjects>

    @Transaction
    @Query("SELECT * FROM students_cross_subjects, subject WHERE students_cross_subjects.subject_id = :subjectId AND subject.subject_id = :subjectId")
    suspend fun getSubjectWithStudents(subjectId: Long): List<SubjectWithStudents>
}