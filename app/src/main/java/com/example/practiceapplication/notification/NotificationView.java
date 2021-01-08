package com.example.practiceapplication.notification;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practiceapplication.R;

public class NotificationView extends AppCompatActivity {
    private TextView notification_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_view);

        notification_txt = findViewById(R.id.notification_txt);

        notification_txt.setText(getIntent().getStringExtra("message"));
    }
}