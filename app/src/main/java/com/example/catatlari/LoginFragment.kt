package com.example.catatlari

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Kenalkan ID dari file XML ke Kotlin
        // PENTING: Pastikan R.id.edtEmail dan R.id.btnLogin sesuai dengan ID di fragment_login.xml
        val edtEmailLogin = view.findViewById<EditText>(R.id.edtEmail)
        val btnLogin = view.findViewById<Button>(R.id.btnLogin)

        // 2. Tangkap Bundle yang dilempar dari RegistrasiFragment (Syarat Nilai 85+)
        if (arguments != null) {
            val akun = requireArguments().getSerializable("DATA_AKUN") as? UserAccount
            if (akun != null) {
                // Otomatis isi kolom email di form Login
                edtEmailLogin.setText(akun.email)
                Toast.makeText(requireContext(), "Halo ${akun.nama}, silakan login", Toast.LENGTH_SHORT).show()
            }
        }

        // 3. Logika tombol Login -> Pindah ke BerandaFragment
        btnLogin.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, BerandaFragment())
                .addToBackStack(null) // Biar user bisa pakai tombol 'Back' di HP
                .commit()
        }
    }
}