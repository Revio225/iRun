package com.example.catatlari

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RunAdapter(private val list: ArrayList<RunData>) :
    RecyclerView.Adapter<RunAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTanggal: TextView = view.findViewById(R.id.tvTanggal)
        val tvJarak: TextView = view.findViewById(R.id.tvJarak)
        val tvWaktu: TextView = view.findViewById(R.id.tvWaktu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_run, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.tvTanggal.text = data.tanggal
        holder.tvJarak.text = "Jarak: ${data.jarak} km"
        holder.tvWaktu.text = "Waktu: ${data.waktu}"
    }
}