package com.example.informationapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var langSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        val btnMenu = findViewById<View>(R.id.btnMenu)

        // Your drawer TextViews
        val navHome = findViewById<TextView>(R.id.nav_home)
        val navHotline = findViewById<TextView>(R.id.nav_hotline)
        val navOt = findViewById<TextView>(R.id.nav_ot)
        val navMassey = findViewById<TextView>(R.id.nav_massey)
        val navAbout = findViewById<TextView>(R.id.nav_about)
        langSpinner = findViewById(R.id.lang_spinner)

        btnMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.END)
        }

        // Click listeners for drawer items
        navHome.setOnClickListener {
            drawerLayout.closeDrawer(GravityCompat.END)
        }

        navHotline.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:111") // Replace with real number
            startActivity(callIntent)
            drawerLayout.closeDrawer(GravityCompat.END)
        }

        navOt.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.orangatamariki.govt.nz/"))
            startActivity(browserIntent)
            drawerLayout.closeDrawer(GravityCompat.END)
        }

        navMassey.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.massey.ac.nz/"))
            startActivity(browserIntent)
            drawerLayout.closeDrawer(GravityCompat.END)
        }

        navAbout.setOnClickListener {
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
            drawerLayout.closeDrawer(GravityCompat.END)
        }

        // Setup language spinner
        val languages = arrayOf("English", "Māori")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        langSpinner.adapter = adapter

        // Set spinner selection based on current locale
        val currentLang = Locale.getDefault().language
        langSpinner.setSelection(if (currentLang == "mi") 1 else 0)

        langSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val langCode = if (position == 0) "en" else "mi"
                if (langCode != Locale.getDefault().language) {
                    setLocale(langCode)
                }
                drawerLayout.closeDrawer(GravityCompat.END)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        createConfigurationContext(config)
        recreate()
    }
}