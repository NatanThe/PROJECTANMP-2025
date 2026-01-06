package com.example.uts_miniproject.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @ColumnInfo(name="usia")
    val usia: Int,
    @ColumnInfo(name="tinggi")
    val tinggi: Float,
    @ColumnInfo(name="berat")
    val berat: Float
){
    @PrimaryKey(autoGenerate = true)
    var uuid: Int=0
}