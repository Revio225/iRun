package com.example.catatlari

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class TambahLariFragment : Fragment(R.layout.fragment_tambahlari) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSimpan = view.findViewById<Button>(R.id.btnSimpan)

        // Logika tombol Simpan -> Kembali ke Beranda
        btnSimpan.setOnClickListener {
            Toast.makeText(requireContext(), "Data Lari Disimpan!", Toast.LENGTH_SHORT).show()

            // Perintah untuk kembali ke halaman sebelumnya (Beranda)
            parentFragmentManager.popBackStack()
        }
    }
}