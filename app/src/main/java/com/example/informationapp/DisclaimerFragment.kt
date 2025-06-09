package com.example.informationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class DisclaimerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.activity_disclaimer, container, false)

        val acceptButton = view.findViewById<Button>(R.id.accept_button)
        acceptButton.setOnClickListener {
            // Load the HomeFragment when Accept is clicked
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
