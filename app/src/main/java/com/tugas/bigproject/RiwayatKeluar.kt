package com.tugas.bigproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.bigproject.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RiwayatKeluar : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var keluarAdapter: KeluarAdapter
    private lateinit var listHistoryKeluar: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat_keluar)
        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Riwayat Keluar  "
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        setupList()
    }

    override fun onStart() {
        super.onStart()
        getKeluar()
    }
    private fun setupList(){
        listHistoryKeluar = findViewById(R.id.list_riwayat_keluar)
        keluarAdapter = KeluarAdapter(arrayListOf())
        listHistoryKeluar.adapter = keluarAdapter
    }
    private fun getKeluar(){
        api.data_keluar().enqueue(object : Callback<KeluarModel>{
            override fun onResponse(call: Call<KeluarModel>, response: Response<KeluarModel>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.history_keluar
                    keluarAdapter.setData( listData )
//                    listData.forEach {
//                        Log.e("MainActivity", "nama ${it.nama}")
//                    }

                }
            }

            override fun onFailure(call: Call<KeluarModel>, t: Throwable) {
                Log.e("RiwayatKeluar",t.toString())
            }

        })
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}