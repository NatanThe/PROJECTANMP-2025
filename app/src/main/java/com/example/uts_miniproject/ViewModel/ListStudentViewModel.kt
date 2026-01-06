package com.example.uts_miniproject.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.uts_miniproject.Model.Student
import com.example.uts_miniproject.Model.StudentDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListStudentViewModel (application: Application)
    : AndroidViewModel(application), CoroutineScope {
    val studentLD = MutableLiveData<List<Student>>()
    val studentLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun refresh() {
        loadingLD.value = true
        studentLoadErrorLD.value = false
        launch {
            val db = StudentDatabase.buildDatabase(
                getApplication()
            )

            studentLD.postValue(db.studentDao().selectAllTodo())
            loadingLD.postValue(false)
        }
    }
    fun clearTask(student: Student) {
        launch {
            val db = StudentDatabase.buildDatabase(
                getApplication()
            )
            db.studentDao().deleteTodo(student)

            studentLD.postValue(db.studentDao().selectAllTodo())
        }
    }


}