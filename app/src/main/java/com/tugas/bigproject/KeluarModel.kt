package com.tugas.bigproject

class KeluarModel (
    val history_keluar: List<DataKeluar>
){
    data class DataKeluar(
        val no_plat: String?,
        val waktu_keluar: String?,
        val no_identitas: String?
    )
}