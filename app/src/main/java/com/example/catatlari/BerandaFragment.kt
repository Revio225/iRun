package com.example.catatlari

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BerandaFragment : Fragment(R.layout.fragment_beranda) {

    private lateinit var adapter: RunAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 🔥 1. Setup RecyclerView
        val rvHistory = view.findViewById<RecyclerView>(R.id.rvHistory)

        adapter = RunAdapter(RunRepository.listRun)
        rvHistory.layoutManager = LinearLayoutManager(requireContext())
        rvHistory.adapter = adapter

        // 🔥 2. Listener menerima data dari TambahLariFragment
        parentFragmentManager.setFragmentResultListener("REQ_LARI", viewLifecycleOwner) { _, bundle ->

            val hasilLari = bundle.getSerializable("DATA_LARI") as? RunData

            if (hasilLari != null) {

                // ✅ SIMPAN DATA
                RunRepository.listRun.add(hasilLari)

                // ✅ REFRESH LIST
                adapter.notifyDataSetChanged()

                Toast.makeText(requireContext(),
                    "Sukses! ${hasilLari.jarak} km ditambahkan",
                    Toast.LENGTH_SHORT).show()
            }
        }

        // 🔥 3. Tombol tambah
        val fabAdd = view.findViewById<FloatingActionButton>(R.id.fabAdd)
        fabAdd.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TambahLariFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}