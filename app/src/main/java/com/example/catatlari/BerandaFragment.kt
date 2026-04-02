package com.example.catatlari

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BerandaFragment : Fragment(R.layout.fragment_beranda) {

    private lateinit var adapter: RunAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Setup RecyclerView
        val rvHistory = view.findViewById<RecyclerView>(R.id.rvHistory)

        // Gunakan list dari repository
        adapter = RunAdapter(RunRepository.listRun)
        rvHistory.layoutManager = LinearLayoutManager(requireContext())
        rvHistory.adapter = adapter

        // 2. Listener menerima data dari TambahLariFragment
        parentFragmentManager.setFragmentResultListener("REQ_LARI", viewLifecycleOwner) { _, bundle ->
            val hasilLari = bundle.getSerializable("DATA_LARI") as? RunData
            if (hasilLari != null) {
                // Simpan dan refresh list
                RunRepository.listRun.add(hasilLari)
                adapter.notifyDataSetChanged()

                Toast.makeText(requireContext(),
                    "Sukses! ${hasilLari.jarak} km ditambahkan",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}