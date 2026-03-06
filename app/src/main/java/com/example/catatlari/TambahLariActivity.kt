package com.example.catatlari

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TambahLariActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_lari) // XML: activity_tambah_lari.xml

        val etTanggal = findViewById<EditText>(R.id.tanggal)
        val etJarak = findViewById<EditText>(R.id.jarak)
        val etWaktu = findViewById<EditText>(R.id.waktu)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        // Logika Tombol Simpan
        btnSimpan.setOnClickListener {
            val tanggal = etTanggal.text.toString()
            val jarak = etJarak.text.toString()
            val waktu = etWaktu.text.toString()

            if (tanggal.isNotEmpty() && jarak.isNotEmpty() && waktu.isNotEmpty()) {
                // Tampilkan pesan berhasil
                Toast.makeText(this, "Lari $jarak km berhasil disimpan!", Toast.LENGTH_LONG).show()

                // Tutup halaman ini dan kembali ke Beranda
                finish()
            } else {
                Toast.makeText(this, "Mohon lengkapi data lari kamu!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}