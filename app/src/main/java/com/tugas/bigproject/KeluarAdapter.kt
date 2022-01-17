package com.tugas.bigproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bigproject.R

class KeluarAdapter (
    val history_keluars: ArrayList<KeluarModel.DataKeluar>
):RecyclerView.Adapter<KeluarAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = history_keluars[position]
        holder.textPlat.text = data.no_plat
        holder.textWaktu.text = data.waktu_keluar
        holder.textIdentitas.text = data.no_identitas
    }

    override fun getItemCount()=history_keluars.size
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textPlat = view.findViewById<TextView>(R.id.text_platnomor)
        val textWaktu = view.findViewById<TextView>(R.id.text_waktu)
        val textIdentitas = view.findViewById<TextView>(R.id.text_noidentitas)
    }
    public fun setData(data: List<KeluarModel.DataKeluar>){
        history_keluars.clear()
        history_keluars.addAll(data)
        notifyDataSetChanged()
    }
}