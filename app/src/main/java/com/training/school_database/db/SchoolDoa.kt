package com.training.school_database.db

import androidx.lifecycle.LiveData
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

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = StudentCrossSubject::class)
    suspend fun insertStudentCrossSubject(crossRef: StudentCrossSubject): Long

    /** select: */
    @Query("SELECT * FROM school")
    fun getSchools(): LiveData<List<School>>

    @Query("SELECT * FROM director")
    fun getDirectors(): LiveData<List<Director>>

    @Query("SELECT * FROM student")
    fun getStudents(): LiveData<List<Student>>

    @Query("SELECT * FROM subject")
    fun getSubjects(): LiveData<List<Subject>>

    @Query("SELECT * FROM students_cross_subjects")
    fun getStudentsCrossObjects(): LiveData<List<StudentCrossSubject>>

    @Transaction // multi threads safety.
    @Query("SELECT * FROM school WHERE school_name = :schoolName")
    fun getSchoolAndDirector(schoolName: String): LiveData<List<SchoolAndDirector>>

    @Transaction
    @Query("SELECT * FROM school WHERE school_name = :schoolName")
    fun getSchoolWithStudents(schoolName: String): LiveData<List<SchoolWithStudents>>

    @Transaction
    @Query("SELECT * FROM students_cross_subjects, student WHERE students_cross_subjects.student_id = :studentId AND student.student_id = :studentId")
    fun getStudentWithSubjects(studentId: Long): LiveData<List<StudentsWithSubjects>>

    @Transaction
    @Query("SELECT * FROM students_cross_subjects, subject WHERE students_cross_subjects.subject_id = :subjectId AND subject.subject_id = :subjectId")
    fun getSubjectWithStudents(subjectId: Long): LiveData<List<SubjectWithStudents>>
}