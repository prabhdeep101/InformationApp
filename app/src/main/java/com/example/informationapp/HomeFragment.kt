package com.example.informationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.home_page, container, false)

        // Learn Section
        val toggleLearn = view.findViewById<TextView>(R.id.toggleLearn)
        val learnContent = view.findViewById<LinearLayout>(R.id.learnContent)
        toggleLearn.setOnClickListener {
            toggleVisibility(learnContent)
        }

        // Process Section
        val toggleProcess = view.findViewById<TextView>(R.id.toggleProcess)
        val processContent = view.findViewById<LinearLayout>(R.id.processContent)
        toggleProcess.setOnClickListener {
            toggleVisibility(processContent)
        }

        // Parents Section
        val toggleParents = view.findViewById<TextView>(R.id.toggleParents)
        val parentsContent = view.findViewById<LinearLayout>(R.id.parentsContent)
        toggleParents.setOnClickListener {
            toggleVisibility(parentsContent)
        }

        // Caregivers Section
        val toggleCaregivers = view.findViewById<TextView>(R.id.toggleCaregivers)
        val caregiversContent = view.findViewById<LinearLayout>(R.id.caregiversContent)
        toggleCaregivers.setOnClickListener {
            toggleVisibility(caregiversContent)
        }

        return view
    }

    private fun toggleVisibility(content: LinearLayout) {
        content.visibility = if (content.visibility == View.GONE) View.VISIBLE else View.GONE
    }
}
