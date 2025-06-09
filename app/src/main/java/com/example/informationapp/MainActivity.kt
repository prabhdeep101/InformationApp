package com.example.informationapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // This layout must contain a fragment container

        // Load the splash fragment as the first screen
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SplashFragment())  // Adjust the ID to match your layout
            .commit()
    }
}

