package com.example.informationapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Info1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_learnmore)

        // Fallback to localized strings if intent extras are null
        val titleText = intent.getStringExtra("title") ?: getString(R.string.info1_title)
        val bodyText = intent.getStringExtra("body") ?: getString(R.string.info1_body)
        val labelText = intent.getStringExtra("label") ?: getString(R.string.label_info)
        val linkText = intent.getStringExtra("link") ?: getString(R.string.link_oranga)

        findViewById<TextView>(R.id.titleTextView).text = titleText
        findViewById<TextView>(R.id.bodyTextView).text = bodyText
        findViewById<TextView>(R.id.extraLabelTextView).text = labelText
        findViewById<TextView>(R.id.linkTextView).text = linkText
    }
}
