package com.example.uts_miniproject.View

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.content.edit
import com.example.uts_miniproject.R
import com.example.uts_miniproject.databinding.FragmentProfileBinding
import com.example.uts_miniproject.databinding.FragmentUkurBinding

class FragmentProfile : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        val genderlaki = binding.rbLaki.text.toString()
        val genderperempuan = binding.rbPerempuan.text.toString()


        binding.btnSimpan.setOnClickListener {
            if (binding.rbLaki.isChecked)
            {
                val gender = genderlaki
            }
            else if (binding.rbPerempuan.isChecked)
            {
                val gender = genderperempuan
            }
            val namaText = binding.inputNama.text.toString()
            val DateOfBirthText = binding.inputDOB.text.toString()
            val shareEdit = sharedPreferences.edit()
            shareEdit.putString("name", namaText)
            shareEdit.putString("gender", gender)
            shareEdit.putString("dob", DateOfBirthText)
            shareEdit.apply()
        }

        return binding.root
    }


}