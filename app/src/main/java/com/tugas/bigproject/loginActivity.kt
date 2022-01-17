package com.tugas.bigproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.bigproject.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class loginActivity : AppCompatActivity() {

    private var binding : ActivityLoginBinding? = null
    private var user : String = ""
    private var pass : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.btnLogin.setOnClickListener {
            user = binding!!.inputUser.text.toString()
            pass = binding!!.inputPassword.text.toString()

            when {
                user ==""->{
                    binding!!.textUser.error = "Username tidak boleh kosong"
                    binding!!.textPassword.error = null
                }
                pass ==""->{
                    binding!!.textPassword.error = "Password tidak boleh kosong"
                    binding!!.textUser.error = null
                }
                else ->{
                    getData()
                }
            }
        }
    }
    private fun getData(){
        val api = ApiRetrofit().getInstance()
        api.login(user,pass).enqueue(object : Callback<ResponseLogin>{
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                if(response.isSuccessful){
                    if(response.body()?.response == true){
                        startActivity(Intent(this@loginActivity, MainActivity::class.java))
                        finish()
                    }else {
                        Toast.makeText(
                            this@loginActivity,
                            "Login gagal, username dan password anda salah silahkan cek kembali.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }else{
                    Toast.makeText(
                        this@loginActivity,"Login gagal, terjadi kesalahan", Toast.LENGTH_LONG
                    ).show()
                }

                }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Log.e("LoginActivity","${t.message}")
            }
        })

    }
}