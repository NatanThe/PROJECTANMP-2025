package com.example.uts_miniproject.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uts_miniproject.Adapter.DataUkurAdapter
import com.example.uts_miniproject.Model.Student
import com.example.uts_miniproject.databinding.FragmentDataBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class FragmentData : Fragment() {

    private lateinit var binding: FragmentDataBinding
    private val dataList = mutableListOf<Student>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDataBinding.inflate(inflater, container, false)
        binding.recyclerViewData.layoutManager = LinearLayoutManager(requireContext())

        loadDataFromFile()

        return binding.root
    }

    private fun loadDataFromFile() {
        try {
            val fileInputStream = requireContext().openFileInput("data_ukur.txt")
            val reader = BufferedReader(InputStreamReader(fileInputStream))

            reader.forEachLine { line ->
                val parts = line.split(" ")
                if (parts.size == 3) {
                    val usia = parts[0].toIntOrNull() ?: 0
                    val tinggi = parts[1].toFloatOrNull() ?: 0f
                    val berat = parts[2].toFloatOrNull() ?: 0f
                    dataList.add(Student(usia, tinggi, berat))
                }
            }

            reader.close()
            fileInputStream.close()

            binding.recyclerViewData.adapter = DataUkurAdapter(dataList)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
