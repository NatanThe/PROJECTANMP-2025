package com.example.uts_miniproject.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_miniproject.Model.Student
import com.example.uts_miniproject.databinding.ItemDataBinding

class DataUkurAdapter(private val dataList: List<Student>) :
    RecyclerView.Adapter<DataUkurAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.binding.tvUsia.text = item.usia.toString()
        holder.binding.tvTinggi.text = item.tinggi.toString()
        holder.binding.tvBerat.text = item.berat.toString()
    }

    override fun getItemCount() = dataList.size
}
