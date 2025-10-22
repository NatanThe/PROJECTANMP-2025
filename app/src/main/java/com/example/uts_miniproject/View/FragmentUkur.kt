package com.example.uts_miniproject.View

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.uts_miniproject.databinding.FragmentUkurBinding
import java.io.FileOutputStream

class FragmentUkur : Fragment() {

    private lateinit var binding: FragmentUkurBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 🔹 Gunakan ViewBinding agar sesuai dengan fragment_ukur.xml
        binding = FragmentUkurBinding.inflate(inflater, container, false)

        // 🔹 Tombol tambah data ditekan
        binding.btnTambahData.setOnClickListener {
            val berat = binding.inputBerat.text.toString()
            val tinggi = binding.inputTinggi.text.toString()
            val usia = binding.inputUsia.text.toString()

            if (berat.isEmpty() || tinggi.isEmpty() || usia.isEmpty()) {
                Toast.makeText(requireContext(), "Harap isi semua data!", Toast.LENGTH_SHORT).show()
            } else {
                simpanDataKeFile(berat, tinggi, usia)
                kosongkanInput()
            }
        }

        return binding.root
    }

    // 🔹 Fungsi untuk menyimpan data ke file TXT di internal storage
    private fun simpanDataKeFile(berat: String, tinggi: String, usia: String) {
        val fileName = "data_ukur.txt"
        // Simpan format sederhana tanpa simbol aneh
        val data = "$usia $tinggi $berat\n"

        try {
            val fileOutputStream = requireContext().openFileOutput(fileName, Context.MODE_APPEND)
            fileOutputStream.write(data.toByteArray())
            fileOutputStream.close()
            Toast.makeText(requireContext(), "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Gagal menyimpan: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }


    // 🔹 Kosongkan input setelah data disimpan
    private fun kosongkanInput() {
        binding.inputBerat.setText("")
        binding.inputTinggi.setText("")
        binding.inputUsia.setText("")
    }
}
