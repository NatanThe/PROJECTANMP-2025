package com.example.uts_miniproject.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_miniproject.Model.Student
import com.example.uts_miniproject.R

class DataUkurAdapter(private val dataList: List<Student>) :
    RecyclerView.Adapter<DataUkurAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUsia: TextView = itemView.findViewById(R.id.tvUsia)
        val tvTinggi: TextView = itemView.findViewById(R.id.tvTinggi)
        val tvBerat: TextView = itemView.findViewById(R.id.tvBerat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_data, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.tvUsia.text = item.usia.toString()
        holder.tvTinggi.text = String.format("%.1f", item.tinggi)
        holder.tvBerat.text = String.format("%.1f", item.berat)
    }
}