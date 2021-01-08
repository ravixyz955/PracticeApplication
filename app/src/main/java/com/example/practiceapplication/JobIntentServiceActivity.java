package com.example.practiceapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practiceapplication.service.MyService;

public class JobIntentServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_intent_service);
        Intent serviceIntent = new Intent(getApplicationContext(), MyService.class);
        MyService.enqueueWork(this, serviceIntent);
    }
}