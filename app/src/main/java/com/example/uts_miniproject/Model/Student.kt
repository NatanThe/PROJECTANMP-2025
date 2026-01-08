package com.example.uts_miniproject.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @ColumnInfo(name="nama")
    val nama: String,
    @ColumnInfo(name="tanggal lahir")
    val dob: String,
    @ColumnInfo(name="usia")
    val usia: Int,
    @ColumnInfo(name="berat")
    val berat: Float,
    @ColumnInfo(name="tinggi")
    val tinggi: Float
){
    @PrimaryKey(autoGenerate = true)
    var uuid: Int=0
}