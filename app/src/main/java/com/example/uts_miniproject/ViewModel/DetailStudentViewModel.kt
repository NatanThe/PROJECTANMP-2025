package com.example.uts_miniproject.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.uts_miniproject.Model.Student
import com.example.uts_miniproject.Model.StudentDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailStudentViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {
    private val job = Job()

    fun addTodo(list:List<Student>) {
        launch {
            val db = StudentDatabase.buildDatabase(
                getApplication()
            )
            db.studentDao().insertAll(*list.toTypedArray())
        }
    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

}
