package com.training.school_database.db

import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.training.school_database.db.entities.Director
import com.training.school_database.db.entities.School
import com.training.school_database.db.entities.Student
import com.training.school_database.db.entities.Subject
import com.training.school_database.db.entities.relations.StudentCrossSubject
import com.training.school_database.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.Executor

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class SchoolDoaTest {
    lateinit var db: SchoolDatabase
    lateinit var dao: SchoolDoa

    @Before
    fun init() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            SchoolDatabase::class.java
        ).allowMainThreadQueries()
         .build()

        dao = db.schoolDao
        Log.d("initTest", "init succeeded")
    }
    @After
    fun finish() {
        db.close()
        Log.d("finishTest", "finish succeeded")
    }

    @Test
    fun insertSchoolTest() = runTest {
        val school = School("Java")
        dao.insertSchool(school)
        val schools = dao.getSchools().getOrAwaitValue()
        assertThat(schools).contains(school)
    }
    @Test
    fun insertDirectorTest() = runTest{
        val director = Director(name = "director_name", schoolName = "school_name")
        dao.insertDirector(director)
        val directors = dao.getDirectors().getOrAwaitValue()
        assertThat(directors.map { it.noId }).contains(director)
    }
    @Test
    fun insertStudentTest() = runTest {
        val student = Student(name = "student_name", schoolName = "school_name", semester = 1)
        dao.insertStudent(student)
        val students = dao.getStudents().getOrAwaitValue()
        assertThat(students.map { it.noId }).contains(student)
    }
    @Test
    fun insertSubjectTest() = runTest {
        val subject = Subject(name = "subject_name")
        dao.insertSubject(subject)
        val subjects = dao.getSubjects().getOrAwaitValue()
        assertThat(subjects.map {it.noId}).contains(subject)
    }
    @Test
    fun insertStudentCrossSubjectTest() = runTest {
        val stu_cross_sbj = StudentCrossSubject(studentId = 1, subjectId = 5)
        dao.insertStudentCrossSubject(stu_cross_sbj)
        val stu_cross_sbj_s = dao.getStudentsCrossObjects().getOrAwaitValue()
        assertThat(stu_cross_sbj_s).contains(stu_cross_sbj)
    }

}