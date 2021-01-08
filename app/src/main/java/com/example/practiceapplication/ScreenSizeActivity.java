package com.example.practiceapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ScreenSizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_size);

        findViewById(R.id.btn1).setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity2.class));
        });
    }
}