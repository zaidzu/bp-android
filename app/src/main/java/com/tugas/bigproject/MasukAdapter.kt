package com.tugas.bigproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bigproject.R
import org.w3c.dom.Text

class MasukAdapter (
    val history_masuks: ArrayList<MasukModel.Data>
): RecyclerView.Adapter<MasukAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = history_masuks[position]
        holder.textPlat.text = data.no_plat
        holder.textWaktu.text = data.waktu_masuk
        holder.textIdentitas.text = data.no_identitas
    }

    override fun getItemCount() = history_masuks.size
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textPlat = view.findViewById<TextView>(R.id.text_platnomor)
        val textWaktu = view.findViewById<TextView>(R.id.text_waktu)
        val textIdentitas = view.findViewById<TextView>(R.id.text_noidentitas)
    }
    public fun setData(data: List<MasukModel.Data>){
        history_masuks.clear()
        history_masuks.addAll(data)
        notifyDataSetChanged()
    }
}