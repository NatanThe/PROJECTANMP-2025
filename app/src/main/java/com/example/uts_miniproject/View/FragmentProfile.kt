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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.uts_miniproject.Model.Student
import com.example.uts_miniproject.R
import com.example.uts_miniproject.ViewModel.DetailStudentViewModel
import com.example.uts_miniproject.databinding.FragmentProfileBinding
import com.example.uts_miniproject.databinding.FragmentUkurBinding

class FragmentProfile : Fragment() {

    private lateinit var viewModel: DetailStudentViewModel
    private lateinit var binding: FragmentProfileBinding
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this)[DetailStudentViewModel::class.java]

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
            var students = Student(
                binding.inputNama.text.toString(),
                binding.inputDOB.text.toString(),
            )
            val list = listOf(students)
            viewModel.addTodo(list)
            Toast.makeText(view.context, "Data added", Toast.LENGTH_LONG).show()
            it.findNavController().popBackStack()

            val namaText = binding.inputNama.text.toString()
            val DateOfBirthText = binding.inputDOB.text.toString()
            val shareEdit = sharedPreferences.edit()
            shareEdit.putString("name", namaText)
            shareEdit.putString("gender", "gender")
            shareEdit.putString("dob", DateOfBirthText)
            shareEdit.apply()
        }
    }

}