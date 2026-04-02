package com.example.catatlari

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*

class TambahLariFragment : Fragment(R.layout.fragment_tambahlari) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. ID tetap sama (tidak diubah)
        val etTanggal = view.findViewById<EditText>(R.id.tanggal)
        val etJarak = view.findViewById<EditText>(R.id.jarak)
        val etWaktu = view.findViewById<EditText>(R.id.waktu)
        val btnSimpan = view.findViewById<Button>(R.id.btnSimpan)

        // 🔥 FORMAT TANGGAL INDONESIA
        val formatTanggal = SimpleDateFormat("dd MMMM yyyy", Locale("id", "ID"))

        // 🔥 2. SET TANGGAL OTOMATIS (hari ini)
        etTanggal.setText(formatTanggal.format(Date()))

        // 🔥 3. DATE PICKER (klik EditText tanggal)
        etTanggal.setOnClickListener {
            val calendar = Calendar.getInstance()

            val datePicker = DatePickerDialog(
                requireContext(),
                { _, year, month, day ->
                    val cal = Calendar.getInstance()
                    cal.set(year, month, day)
                    etTanggal.setText(formatTanggal.format(cal.time))
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )

            datePicker.show()
        }

        // 🔥 OPTIONAL (biar keyboard tidak muncul)
        etTanggal.isFocusable = false

        // 4. Logika tombol Simpan (TIDAK DIUBAH)
        btnSimpan.setOnClickListener {
            val tgl = etTanggal.text.toString().trim()
            val jrk = etJarak.text.toString().trim()
            val wkt = etWaktu.text.toString().trim()

            if (tgl.isNotEmpty() && jrk.isNotEmpty() && wkt.isNotEmpty()) {

                val lariBaru = RunData(tgl, jrk, wkt)

                val bundle = Bundle()
                bundle.putSerializable("DATA_LARI", lariBaru)

                parentFragmentManager.setFragmentResult("REQ_LARI", bundle)
                parentFragmentManager.popBackStack()

            } else {
                Toast.makeText(requireContext(), "Harap isi semua data lari!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}