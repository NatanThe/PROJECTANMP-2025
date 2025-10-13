package com.example.uts_miniproject.Adapter

import android.graphics.Typeface
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_miniproject.Model.Student
import android.view.View
import android.content.Context
import android.view.Gravity

class DataUkurAdapter(private val dataList: List<Student>) :
    RecyclerView.Adapter<DataUkurAdapter.DataUkurViewHolder>() {

    class DataUkurViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUsia: TextView
        val tvTinggi: TextView
        val tvBerat: TextView

        init {
            val layout = itemView as LinearLayout
            tvUsia = layout.getChildAt(0) as TextView
            tvTinggi = layout.getChildAt(1) as TextView
            tvBerat = layout.getChildAt(2) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataUkurViewHolder {
        val context: Context = parent.context

        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(20, 20, 20, 20)
        layout.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val tvUsia = TextView(context)
        tvUsia.textSize = 16f
        tvUsia.setTypeface(null, Typeface.BOLD)
        tvUsia.setPadding(0, 0, 0, 6)

        val tvTinggi = TextView(context)
        tvTinggi.textSize = 15f
        tvTinggi.setPadding(0, 0, 0, 6)

        val tvBerat = TextView(context)
        tvBerat.textSize = 15f
        tvBerat.setPadding(0, 0, 0, 10)

        layout.addView(tvUsia)
        layout.addView(tvTinggi)
        layout.addView(tvBerat)

        return DataUkurViewHolder(layout)
    }

    override fun onBindViewHolder(holder: DataUkurViewHolder, position: Int) {
        val data = dataList[position]
        holder.tvUsia.text = "Usia: " + data.usia + " tahun"
        holder.tvTinggi.text = "Tinggi: " + data.tinggi + " cm"
        holder.tvBerat.text = "Berat: " + data.berat + " kg"
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
