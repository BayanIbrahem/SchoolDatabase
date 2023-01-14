package com.training.school_database.db

import androidx.room.*
import com.training.school_database.db.entities.Director
import com.training.school_database.db.entities.School
import com.training.school_database.db.entities.relations.SchoolAndDirector

@Dao
interface SchoolDoa {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director): Long

//    @Transaction // multi threads safety.

    @Query("SELECT * FROM school WHERE school_name = :schoolName")
    suspend fun getSchoolAndDirector(schoolName: String): List<SchoolAndDirector>
}