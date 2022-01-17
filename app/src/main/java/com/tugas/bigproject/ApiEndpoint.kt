package com.tugas.bigproject

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndpoint {
    @GET("masuk.php")
    fun data(): Call<MasukModel>
    @GET("keluar.php")
    fun data_keluar(): Call<KeluarModel>

    @FormUrlEncoded
    @POST("login.php")
    fun login(
        @Field("post_username") username : String,
        @Field("post_password") password :String
    ): Call<ResponseLogin>
}