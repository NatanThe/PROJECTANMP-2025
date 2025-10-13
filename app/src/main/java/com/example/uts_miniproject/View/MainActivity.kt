package com.example.uts_miniproject.View

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.uts_miniproject.R
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Tombol di drawer
        val menuUkur: TextView = findViewById(R.id.menuUkur)
        val menuData: TextView = findViewById(R.id.menuData)
        val menuProfil: TextView = findViewById(R.id.menuProfil)

        // Fragment default
        if (savedInstanceState == null) {
            replaceFragment(FragmentUkur())
        }

        // Aksi saat diklik
        menuUkur.setOnClickListener {
            replaceFragment(FragmentUkur())
            drawerLayout.closeDrawers()
        }

        menuData.setOnClickListener {
            replaceFragment(FragmentData())
            drawerLayout.closeDrawers()
        }

        menuProfil.setOnClickListener {
            replaceFragment(FragmentProfile())
            drawerLayout.closeDrawers()
        }
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}