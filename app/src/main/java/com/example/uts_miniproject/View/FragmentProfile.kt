package com.example.uts_miniproject.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.uts_miniproject.R
import com.example.uts_miniproject.databinding.FragmentProfileBinding
import com.example.uts_miniproject.databinding.FragmentUkurBinding

class FragmentProfile : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)



        binding.btnSimpan.setOnClickListener {
            val namaText = binding.inputNama.text.toString()
            val DateOfBirthText = binding.inputDOB.text.toString()
        }

        return binding.root
    }


}