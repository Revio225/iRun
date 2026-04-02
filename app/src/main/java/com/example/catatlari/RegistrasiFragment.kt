package com.example.catatlari

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

// Kita ganti namanya jadi RegistrasiFragment dan langsung panggil layoutnya di sini
class RegistrasiFragment : Fragment(R.layout.fragment_registrasi) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Kenalkan ID dari file XML ke Kotlin
        // PENTING: Ubah teks R.id.xxx di bawah ini sesuai dengan ID yang kamu buat di fragment_registrasi.xml
        val edtNama = view.findViewById<EditText>(R.id.edtNama)
        val edtEmail = view.findViewById<EditText>(R.id.edtEmail)
        val edtPass = view.findViewById<EditText>(R.id.edtPass)
        // Ingat: Form re-type password diabaikan sesuai instruksi dosen

        val btnSignup = view.findViewById<Button>(R.id.btnSignup)

        // 2. Saat tombol diklik
        btnSignup.setOnClickListener {
            val nama = edtNama.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val pass = edtPass.text.toString().trim()

            // 3. Cek apakah ada kolom yang kosong
            if (nama.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty()) {

                // 4. Masukkan data ke Data Class
                val akunBaru = UserAccount(nama, email, pass)

                // 5. Bungkus data menggunakan Bundle
                val bundle = Bundle()
                bundle.putSerializable("DATA_AKUN", akunBaru)

                // 6. Siapkan halaman tujuan (Login) dan titipkan Bundle
                val loginFragment = LoginFragment()
                loginFragment.arguments = bundle

                // 7. Lakukan perpindahan layar
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, loginFragment)
                    .commit()

            } else {
                Toast.makeText(requireContext(), "Harap lengkapi semua data!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}