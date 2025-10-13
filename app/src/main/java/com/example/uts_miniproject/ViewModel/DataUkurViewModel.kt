package com.example.uts_miniproject.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.uts_miniproject.Model.Student
import com.example.uts_miniproject.Model.DataUkurRepository

class DataUkurViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = DataUkurRepository(application)
    private val _dataList = MutableLiveData<List<Student>>()
    val dataList: LiveData<List<Student>> get() = _dataList
}
