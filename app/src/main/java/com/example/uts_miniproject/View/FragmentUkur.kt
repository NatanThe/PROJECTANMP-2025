package com.example.uts_miniproject.View

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.uts_miniproject.Model.Student
import com.example.uts_miniproject.Model.StudentDatabase
import com.example.uts_miniproject.databinding.FragmentUkurBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.FileOutputStream

class FragmentUkur : Fragment() {

    private lateinit var binding: FragmentUkurBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentUkurBinding.inflate(inflater, container, false)

        val db = StudentDatabase.getInstance(requireContext())
        val dao = db.studentDao()

        binding.btnTambahData.setOnClickListener {
            val beratText = binding.inputBerat.text.toString()
            val tinggiText = binding.inputTinggi.text.toString()
            val usiaText = binding.inputUsia.text.toString()

            if (beratText.isEmpty() || tinggiText.isEmpty() || usiaText.isEmpty()) {
                Toast.makeText(requireContext(), "Harap isi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val student = Student(
                nama = "User",
                dob = "-",
                usia = usiaText.toInt(),
                berat = beratText.toFloat(),
                tinggi = tinggiText.toFloat()
            )

            // INSERT ke Room
            lifecycleScope.launch {
                withContext(Dispatchers.IO) {
                    dao.insertAll(student)
                }

                Toast.makeText(requireContext(), "Data berhasil disimpan ke Room", Toast.LENGTH_SHORT).show()
                kosongkanInput()
            }
        }

        return binding.root
    }

    private fun kosongkanInput() {
        binding.inputBerat.setText("")
        binding.inputTinggi.setText("")
        binding.inputUsia.setText("")
    }
}