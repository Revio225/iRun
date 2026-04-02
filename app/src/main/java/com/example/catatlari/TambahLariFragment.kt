package com.example.catatlari

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class TambahLariFragment : Fragment(R.layout.fragment_tambahlari) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. ID sudah disesuaikan persis dengan file XML milikmu
        val etTanggal = view.findViewById<EditText>(R.id.tanggal)
        val etJarak = view.findViewById<EditText>(R.id.jarak)
        val etWaktu = view.findViewById<EditText>(R.id.waktu)
        val btnSimpan = view.findViewById<Button>(R.id.btnSimpan)

        // 2. Logika tombol Simpan -> Kirim Data & Kembali ke Beranda
        btnSimpan.setOnClickListener {
            val tgl = etTanggal.text.toString().trim()
            val jrk = etJarak.text.toString().trim()
            val wkt = etWaktu.text.toString().trim()

            // Cek apakah data sudah diisi semua
            if (tgl.isNotEmpty() && jrk.isNotEmpty() && wkt.isNotEmpty()) {

                // Masukkan isian ke dalam Data Class
                val lariBaru = RunData(tgl, jrk, wkt)

                // Bungkus objek ke dalam Bundle
                val bundle = Bundle()
                bundle.putSerializable("DATA_LARI", lariBaru)

                // Kirim hasil kembali ke sistem dengan kunci "REQ_LARI"
                parentFragmentManager.setFragmentResult("REQ_LARI", bundle)

                // Tutup halaman Tambah Lari (otomatis mundur ke Beranda)
                parentFragmentManager.popBackStack()

            } else {
                Toast.makeText(requireContext(), "Harap isi semua data lari!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}