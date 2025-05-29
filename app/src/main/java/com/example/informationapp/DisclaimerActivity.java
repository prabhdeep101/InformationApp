package com.example.informationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DisclaimerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);

        Button acceptButton = findViewById(R.id.accept_button);
        acceptButton.setOnClickListener(v -> {
            Intent intent = new Intent(DisclaimerActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
