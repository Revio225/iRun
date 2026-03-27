package com.example.catatlari

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BerandaFragment : Fragment(R.layout.fragment_beranda) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fabAdd = view.findViewById<FloatingActionButton>(R.id.fabAdd)

        // Logika tombol Tambah (+) -> Pindah ke TambahLariFragment
        fabAdd.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TambahLariFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}