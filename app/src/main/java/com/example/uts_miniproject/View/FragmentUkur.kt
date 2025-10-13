package com.example.uts_miniproject.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.uts_miniproject.databinding.FragmentUkurBinding

class FragmentUkur : Fragment() {

    private lateinit var binding: FragmentUkurBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentUkurBinding.inflate(inflater, container, false)


        binding.btnTambahData.setOnClickListener {
            val usiaText = binding.inputUsia.text.toString()
            val tinggiText = binding.inputTinggi.text.toString()
            val beratText = binding.inputBerat.text.toString()
        }

        return binding.root
    }
    
    private fun kosongkanInput() {
        binding.inputUsia.setText("")
        binding.inputTinggi.setText("")
        binding.inputBerat.setText("")
    }
}
