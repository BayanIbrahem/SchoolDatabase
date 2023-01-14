package com.training.school_database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.training.school_database.db.entities.Director
import com.training.school_database.db.entities.School
import com.training.school_database.db.entities.Student
import com.training.school_database.db.entities.Subject
import com.training.school_database.db.entities.relations.StudentsCrossSubjects

@Database(
    entities = [
        School::class, Director::class, Student::class, Subject::class, StudentsCrossSubjects::class],
    version = 8
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao: SchoolDoa

    companion object {
// any change of this value is visible instantly to other threads, that means no thread will change its value unexceptionable
        @Volatile
        private var instance: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                return if (instance != null ) {
                    instance!!
                } else {
                    Room.databaseBuilder(
                        context,
                        SchoolDatabase::class.java,
                        "school_db",
                    ).build().also {
                        instance = it
                    }
                }
            }
        }
    }
}