package com.example.catatlari

import java.io.Serializable

// Ingat: Mengabaikan re-type password sesuai instruksi soal
data class UserAccount(
    val nama: String,
    val email: String,
    val pass: String
) : Serializable // Menjadikan objek bisa dibungkus dan dikirim