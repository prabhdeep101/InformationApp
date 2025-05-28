package com.example.informationapp

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_InformationApp) // <- important if crashing due to theme
        setContentView(R.layout.home_page)

        // Learn Section
        val toggleLearn = findViewById<TextView>(R.id.toggleLearn)
        val learnContent = findViewById<LinearLayout>(R.id.learnContent)
        toggleLearn.setOnClickListener {
            toggleVisibility(learnContent)
        }

        // Process Section
        val toggleProcess = findViewById<TextView>(R.id.toggleProcess)
        val processContent = findViewById<LinearLayout>(R.id.processContent)
        toggleProcess.setOnClickListener {
            toggleVisibility(processContent)
        }

        // Parents Section
        val toggleParents = findViewById<TextView>(R.id.toggleParents)
        val parentsContent = findViewById<LinearLayout>(R.id.parentsContent)
        toggleParents.setOnClickListener {
            toggleVisibility(parentsContent)
        }

        // Caregivers Section
        val toggleCaregivers = findViewById<TextView>(R.id.toggleCaregivers)
        val caregiversContent = findViewById<LinearLayout>(R.id.caregiversContent)
        toggleCaregivers.setOnClickListener {
            toggleVisibility(caregiversContent)
        }
    }

    private fun toggleVisibility(content: LinearLayout) {
        if (content.visibility == View.GONE) {
            content.visibility = View.VISIBLE
        } else {
            content.visibility = View.GONE
        }
    }
}
