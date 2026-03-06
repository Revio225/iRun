package com.example.catatlari

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// Ganti nama class dari 'login' (huruf kecil) ke 'LoginActivity' (PascalCase)
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}