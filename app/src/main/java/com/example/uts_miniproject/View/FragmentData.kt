package com.example.uts_miniproject.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uts_miniproject.Adapter.DataUkurAdapter
import com.example.uts_miniproject.ViewModel.DataUkurViewModel
import com.example.uts_miniproject.databinding.FragmentDataBinding

class FragmentData : Fragment() {

    private lateinit var binding: FragmentDataBinding
    private val viewModel: DataUkurViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDataBinding.inflate(inflater, container, false)

        binding.rvData.layoutManager = LinearLayoutManager(requireContext())

        viewModel.dataList.observe(viewLifecycleOwner) { list ->
            binding.rvData.adapter = DataUkurAdapter(list)
        }



        return binding.root
    }
}
