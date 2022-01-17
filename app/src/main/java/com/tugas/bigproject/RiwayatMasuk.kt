package com.tugas.bigproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.bigproject.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RiwayatMasuk : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var masukAdapter: MasukAdapter
    private lateinit var listHistoryMasuk: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat_masuk)
        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Riwayat Masuk  "
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        setupList()
    }

    override fun onStart() {
        super.onStart()
        getMasuk()
    }

    private fun setupList(){
        listHistoryMasuk = findViewById(R.id.list_riwayat_masuk)
        masukAdapter = MasukAdapter(arrayListOf())
        listHistoryMasuk.adapter = masukAdapter
    }
    private fun getMasuk(){
        api.data().enqueue(object : Callback<MasukModel>{
            override fun onResponse(call: Call<MasukModel>, response: Response<MasukModel>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.history_masuk
                    masukAdapter.setData( listData )
//                    listData.forEach {
//                        Log.e("MainActivity", "nama ${it.nama}")
//                    }

                }
            }

            override fun onFailure(call: Call<MasukModel>, t: Throwable) {
                Log.e("RiwayatMasuk",t.toString())
            }

        })
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}