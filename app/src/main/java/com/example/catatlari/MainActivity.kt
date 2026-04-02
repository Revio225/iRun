package com.example.catatlari

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var bottomAppBar: BottomAppBar
    private lateinit var fabTambahLari: FloatingActionButton
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomAppBar = findViewById(R.id.bottomAppBar)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        fabTambahLari = findViewById(R.id.fabTambahLari)

        // Set default fragment saat pertama kali dibuka
        if (savedInstanceState == null) {
            replaceFragment(LoginFragment())
        }

        // Listener otomatis untuk menyembunyikan/menampilkan Navbar berdasarkan Fragment yang aktif
        supportFragmentManager.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {
            override fun onFragmentViewCreated(fm: FragmentManager, f: Fragment, v: View, savedInstanceState: Bundle?) {
                super.onFragmentViewCreated(fm, f, v, savedInstanceState)
                when (f) {
                    is LoginFragment, is RegistrasiFragment -> setBottomNavigationVisibility(false)
                    else -> setBottomNavigationVisibility(true)
                }
            }
        }, false)

        // Navigasi lewat Bottom Navigation
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_beranda -> {
                    replaceFragment(BerandaFragment())
                    true
                }
                R.id.nav_profil -> {
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }

        // Navigasi lewat Tombol Tambah (Highlight)
        fabTambahLari.setOnClickListener {
            replaceFragment(TambahLariFragment())
            // Reset selection di bottom nav
            bottomNavigationView.menu.findItem(R.id.nav_placeholder).isChecked = true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun setBottomNavigationVisibility(isVisible: Boolean) {
        if (isVisible) {
            bottomAppBar.visibility = View.VISIBLE
            fabTambahLari.visibility = View.VISIBLE
        } else {
            bottomAppBar.visibility = View.GONE
            fabTambahLari.visibility = View.GONE
        }
    }
}