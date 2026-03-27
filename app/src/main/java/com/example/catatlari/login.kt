package com.example.catatlari

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class LoginFragment : Fragment(R.layout.fragment_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)

        // Logika tombol Login -> Pindah ke BerandaFragment
        btnLogin.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, BerandaFragment())
                .addToBackStack(null) // Biar bisa tombol 'Back' di HP
                .commit()
        }
    }
}