package com.example.catatlari

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi) // XML: activity_registrasi.xml

        val edtNama = findViewById<EditText>(R.id.edtNama)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPass = findViewById<EditText>(R.id.edtPass)
        val btnSignup = findViewById<Button>(R.id.btnSignup)
        val txtLogin = findViewById<TextView>(R.id.txtLogin)

        // 1. Logika Tombol Sign Up
        btnSignup.setOnClickListener {
            val nama = edtNama.text.toString()
            val email = edtEmail.text.toString()
            val pass = edtPass.text.toString()

            if (nama.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Mohon lengkapi semua data!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Akun $nama berhasil dibuat!", Toast.LENGTH_SHORT).show()
                finish() // Kembali ke halaman Login
            }
        }

        // 2. Logika Teks "Sudah punya akun? Login"
        txtLogin.setOnClickListener {
            finish() // Kembali ke halaman Login
        }
    }
}