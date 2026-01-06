package com.example.uts_miniproject.Model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg student: Student)

    @Query("SELECT * FROM Student")
    fun selectAllTodo(): List<Student>

    @Query("SELECT * FROM student WHERE uuid= :id")
    fun selectTodo(id:Int): Student

    @Delete
    fun deleteTodo(todo: Student)
}
