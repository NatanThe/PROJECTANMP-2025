package com.example.uts_miniproject.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uts_miniproject.Model.Student
import com.example.uts_miniproject.Model.DataUkurRepository

class DataUkurViewModel : ViewModel() {

    // Data tersimpan di memory (list observable)
    private val _dataList = MutableLiveData<MutableList<Student>>(mutableListOf())
    val dataList: LiveData<MutableList<Student>> get() = _dataList

    fun tambahData(student: Student) {
        val currentList = _dataList.value ?: mutableListOf()
        currentList.add(student)
        _dataList.value = currentList
    }
}
