package com.example.uts_miniproject.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uts_miniproject.Adapter.DataUkurAdapter
import com.example.uts_miniproject.Model.Student
import com.example.uts_miniproject.Model.StudentDatabase
import com.example.uts_miniproject.databinding.FragmentDataBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader

class FragmentData : Fragment() {

    private lateinit var binding: FragmentDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDataBinding.inflate(inflater, container, false)
        binding.recyclerViewData.layoutManager = LinearLayoutManager(requireContext())

        loadDataFromRoom()

        return binding.root
    }

    private fun loadDataFromRoom() {
        val db = StudentDatabase.getInstance(requireContext())
        val dao = db.studentDao()

        lifecycleScope.launch {
            val dataList = withContext(Dispatchers.IO) {
                dao.selectAllTodo()
            }

            binding.recyclerViewData.adapter = DataUkurAdapter(dataList)
        }
    }
}