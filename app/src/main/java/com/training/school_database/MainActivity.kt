package com.training.school_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.training.school_database.db.SchoolDatabase
import com.training.school_database.db.entities.Director
import com.training.school_database.db.entities.School
import com.training.school_database.db.entities.Student
import com.training.school_database.db.entities.Subject
import com.training.school_database.db.entities.relations.StudentsCrossSubjects
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = SchoolDatabase.getInstance(this).schoolDao

        val directors = listOf(
            Director(name = "Mark", schoolName = "Kotlin"),
            Director(name = "Markof", schoolName = "Kotlin"),
            Director(name = "Monk", schoolName = "Swift"),
            Director(name = "Monky-d-lofi", schoolName = "Swift"),
            Director(name = "Mozart", schoolName = "Jetbrains"),
            Director(name = "Mozart-Maala", schoolName = "Jetbrains"),
            Director(name = "Steve", schoolName = "Java"),
            Director(name = "Steve-jobs", schoolName = "Java"),
        )
        val schools = listOf(
            School(name = "Java"),
            School(name = "Jetbrains"),
            School(name = "Kotlin"),
            School(name = "Swift"),
        )
        val students = listOf (
            Student(name = "Mosh", schoolName = "Java", semester = 1),
            Student(name = "Last", schoolName = "Java", semester = 2),
            Student(name = "Domn", schoolName = "Java", semester = 3),

            Student(name = "Domi", schoolName = "Kotlin", semester = 1),
            Student(name = "SB", schoolName = "Kotlin", semester = 1),
            Student(name = "Semer", schoolName = "Kotlin", semester = 2),
            Student(name = "Safi", schoolName = "Kotlin", semester = 3),

            Student(name = "Model", schoolName = "Jetbrains", semester = 2),
            Student(name = "Seven", schoolName = "Jetbrains", semester = 1),
            Student(name = "Barbareta", schoolName = "Jetbrains", semester = 2),
            Student(name = "Alan", schoolName = "Jetbrains", semester = 1),
            Student(name = "Scare", schoolName = "Jetbrains", semester = 3),

            Student(name = "Sneak", schoolName = "Swift", semester = 3),
            Student(name = "Meso", schoolName = "Swift", semester = 2),
            Student(name = "Mark", schoolName = "Swift", semester = 2),
            Student(name = "Dam", schoolName = "Swift", semester = 3),
            Student(name = "foji", schoolName = "Swift", semester = 3),
            Student(name = "Moshi", schoolName = "Swift", semester = 3),
        )
        val subjects = listOf(
            Subject(name = "MATH"),
            Subject(name = "AP"),
            Subject(name = "AP2"),
            Subject(name = "DB"),
            Subject(name = "ANDROID"),
        )
        val studentsCrossSubjects = listOf(
            StudentsCrossSubjects(studentId = 1, subjectId = 1),
            StudentsCrossSubjects(studentId = 1, subjectId = 2),
            StudentsCrossSubjects(studentId = 1, subjectId = 3),
            StudentsCrossSubjects(studentId = 1, subjectId = 4),
            StudentsCrossSubjects(studentId = 1, subjectId = 5),
            StudentsCrossSubjects(studentId = 10, subjectId = 1),
            StudentsCrossSubjects(studentId = 10, subjectId = 2),
            StudentsCrossSubjects(studentId = 10, subjectId = 3),
            StudentsCrossSubjects(studentId = 10, subjectId = 4),
            StudentsCrossSubjects(studentId = 10, subjectId = 5),
            StudentsCrossSubjects(studentId = 11, subjectId = 1),
            StudentsCrossSubjects(studentId = 11, subjectId = 2),
            StudentsCrossSubjects(studentId = 11, subjectId = 3),
            StudentsCrossSubjects(studentId = 11, subjectId = 4),
            StudentsCrossSubjects(studentId = 11, subjectId = 5),
            StudentsCrossSubjects(studentId = 12, subjectId = 1),
            StudentsCrossSubjects(studentId = 12, subjectId = 2),
            StudentsCrossSubjects(studentId = 12, subjectId = 3),
            StudentsCrossSubjects(studentId = 12, subjectId = 4),
            StudentsCrossSubjects(studentId = 12, subjectId = 5),
            StudentsCrossSubjects(studentId = 13, subjectId = 1),
            StudentsCrossSubjects(studentId = 13, subjectId = 2),
            StudentsCrossSubjects(studentId = 13, subjectId = 3),
            StudentsCrossSubjects(studentId = 13, subjectId = 4),
            StudentsCrossSubjects(studentId = 13, subjectId = 5),
            StudentsCrossSubjects(studentId = 14, subjectId = 1),
            StudentsCrossSubjects(studentId = 14, subjectId = 2),
            StudentsCrossSubjects(studentId = 14, subjectId = 3),
            StudentsCrossSubjects(studentId = 14, subjectId = 4),
            StudentsCrossSubjects(studentId = 14, subjectId = 5),
            StudentsCrossSubjects(studentId = 15, subjectId = 1),
            StudentsCrossSubjects(studentId = 15, subjectId = 2),
            StudentsCrossSubjects(studentId = 15, subjectId = 3),
            StudentsCrossSubjects(studentId = 15, subjectId = 4),
            StudentsCrossSubjects(studentId = 15, subjectId = 5),
            StudentsCrossSubjects(studentId = 2, subjectId = 1),
            StudentsCrossSubjects(studentId = 2, subjectId = 2),
            StudentsCrossSubjects(studentId = 2, subjectId = 3),
            StudentsCrossSubjects(studentId = 2, subjectId = 4),
            StudentsCrossSubjects(studentId = 2, subjectId = 5),
            StudentsCrossSubjects(studentId = 3, subjectId = 1),
            StudentsCrossSubjects(studentId = 3, subjectId = 2),
            StudentsCrossSubjects(studentId = 3, subjectId = 3),
            StudentsCrossSubjects(studentId = 3, subjectId = 4),
            StudentsCrossSubjects(studentId = 3, subjectId = 5),
            StudentsCrossSubjects(studentId = 4, subjectId = 1),
            StudentsCrossSubjects(studentId = 4, subjectId = 2),
            StudentsCrossSubjects(studentId = 4, subjectId = 3),
            StudentsCrossSubjects(studentId = 4, subjectId = 4),
            StudentsCrossSubjects(studentId = 4, subjectId = 5),
            StudentsCrossSubjects(studentId = 5, subjectId = 1),
            StudentsCrossSubjects(studentId = 5, subjectId = 2),
            StudentsCrossSubjects(studentId = 5, subjectId = 3),
            StudentsCrossSubjects(studentId = 5, subjectId = 4),
            StudentsCrossSubjects(studentId = 5, subjectId = 5),
            StudentsCrossSubjects(studentId = 6, subjectId = 1),
            StudentsCrossSubjects(studentId = 6, subjectId = 2),
            StudentsCrossSubjects(studentId = 6, subjectId = 3),
            StudentsCrossSubjects(studentId = 6, subjectId = 4),
            StudentsCrossSubjects(studentId = 6, subjectId = 5),
            StudentsCrossSubjects(studentId = 7, subjectId = 1),
            StudentsCrossSubjects(studentId = 7, subjectId = 2),
            StudentsCrossSubjects(studentId = 7, subjectId = 3),
            StudentsCrossSubjects(studentId = 7, subjectId = 4),
            StudentsCrossSubjects(studentId = 7, subjectId = 5),
            StudentsCrossSubjects(studentId = 8, subjectId = 1),
            StudentsCrossSubjects(studentId = 8, subjectId = 2),
            StudentsCrossSubjects(studentId = 8, subjectId = 3),
            StudentsCrossSubjects(studentId = 8, subjectId = 4),
            StudentsCrossSubjects(studentId = 8, subjectId = 5),
            StudentsCrossSubjects(studentId = 9, subjectId = 1),
            StudentsCrossSubjects(studentId = 9, subjectId = 2),
            StudentsCrossSubjects(studentId = 9, subjectId = 3),
            StudentsCrossSubjects(studentId = 9, subjectId = 4),
            StudentsCrossSubjects(studentId = 9, subjectId = 5),
        )
        lifecycleScope.launchWhenCreated {
            withContext(Dispatchers.IO) {
                directors.forEach {dao.insertDirector(it)}
                schools.forEach {dao.insertSchool(it)}
                students.forEach {dao.insertStudent(it)}
                subjects.forEach {dao.insertSubject(it)}
                studentsCrossSubjects.forEach {dao.insertStudentCrossSubject(it)}
            }
        }
    }
}