package com.example.catatlari

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BerandaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda) // Pastikan ini layout Dashboard (Snippet 3)

        // 1. Kenalan sama tombol Tambah (+)
        val fabTambah = findViewById<FloatingActionButton>(R.id.fabAdd)

        // 2. Kalau tombol + dipencet, pergi ke halaman Form
        fabTambah.setOnClickListener {
            val intent = Intent(this, TambahLariActivity::class.java)
            startActivity(intent)
        }
    }
}
