package com.example.catatlari

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BerandaFragment : Fragment(R.layout.fragment_beranda) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Pasang "Telinga" untuk mendengarkan kiriman data dari TambahLariFragment
        parentFragmentManager.setFragmentResultListener("REQ_LARI", viewLifecycleOwner) { _, bundle ->

            // Buka bungkusan data dan jadikan objek RunData
            val hasilLari = bundle.getSerializable("DATA_LARI") as? RunData

            if (hasilLari != null) {
                // Munculkan notifikasi sukses pakai data dari objek! (Target Nilai 85+ tercapai!)
                Toast.makeText(requireContext(),
                    "Sukses! Aktivitas dicatat: ${hasilLari.jarak} km pada ${hasilLari.tanggal}",
                    Toast.LENGTH_LONG).show()
            }
        }

        // 2. Logika tombol Tambah (+) -> Pindah ke TambahLariFragment
        val fabAdd = view.findViewById<FloatingActionButton>(R.id.fabAdd)
        fabAdd.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TambahLariFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}