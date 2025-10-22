package com.example.uts_miniproject.View

import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import com.example.uts_miniproject.R

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Tombol buka drawer
        findViewById<ImageView>(R.id.btnDrawer).setOnClickListener {
            if (drawerLayout.isDrawerOpen(drawerLayout.getChildAt(1))) {
                drawerLayout.closeDrawers()
            } else {
                drawerLayout.openDrawer(drawerLayout.getChildAt(1))
            }
        }

        // Navigasi drawer
        findViewById<TextView>(R.id.menuUkur).setOnClickListener {
            replaceFragment(FragmentUkur())
            drawerLayout.closeDrawers()
        }

        findViewById<TextView>(R.id.menuData).setOnClickListener {
            replaceFragment(FragmentData())
            drawerLayout.closeDrawers()
        }

        findViewById<TextView>(R.id.menuProfil).setOnClickListener {
            replaceFragment(FragmentProfile())
            drawerLayout.closeDrawers()
        }

        // Navigasi bottom bar
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_ukur -> replaceFragment(FragmentUkur())
                R.id.nav_data -> replaceFragment(FragmentData())
                R.id.nav_profil -> replaceFragment(FragmentProfile())
            }
            true
        }

        // Fragment awal
        replaceFragment(FragmentUkur())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
