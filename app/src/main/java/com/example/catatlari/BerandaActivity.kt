package com.example.catatlari

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BerandaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda) // XML: activity_beranda.xml

        val tvGreeting = findViewById<TextView>(R.id.tvGreetingUser)
        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAdd)

        // Opsional: Mengubah teks sapaan (bisa dinamis nanti)
        tvGreeting.text = "Halo, Naufal!\nSiap lari hari ini?"

        // Logika Tombol Tambah (+) -> Pindah ke Form Input
        fabAdd.setOnClickListener {
            val intent = Intent(this, TambahLariActivity::class.java)
            startActivity(intent)
        }
    }
}