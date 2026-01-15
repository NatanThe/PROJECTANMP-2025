package com.example.uts_miniproject.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Student::class), version =  1)
abstract class StudentDatabase: RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object {
        @Volatile
        private var instance: StudentDatabase? = null
        private val LOCK = Any()

        fun getInstance(context: Context): StudentDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    StudentDatabase::class.java,
                    "newtododb"
                ).build().also {
                    instance = it
                }
            }
        }

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                StudentDatabase::class.java,
                "newtododb"
            ).build()

        operator fun invoke(context: Context) {
            if (instance == null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it

                    }
                }
            }
        }
    }
}