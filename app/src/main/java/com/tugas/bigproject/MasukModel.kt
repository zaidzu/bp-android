package com.tugas.bigproject

class MasukModel (
    val history_masuk: List<Data>
){
    data class Data(
        val no_plat: String?,
        val waktu_masuk: String?,
        val no_identitas: String?
    )
}