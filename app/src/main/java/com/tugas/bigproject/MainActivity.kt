package com.tugas.bigproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.bigproject.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        btnRiwayatMasuk.setOnClickListener {
            intent = Intent(this, RiwayatMasuk::class.java)
            startActivity(intent)
        }
        btnRiwayatKeluar.setOnClickListener {
            intent = Intent(this, RiwayatKeluar::class.java)
            startActivity(intent)
        }
        btnLogout.setOnClickListener {
            intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }
    }

}