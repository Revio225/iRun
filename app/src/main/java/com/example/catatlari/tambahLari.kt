package com.example.catatlari

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TambahLariActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_lari) // Ini layout Form (Snippet 1)

        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        btnSimpan.setOnClickListener {
            // Logika simpan di sini
            Toast.makeText(this, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()

            // Opsional: Tutup halaman form dan balik ke beranda otomatis
            finish()
        }
    }
}