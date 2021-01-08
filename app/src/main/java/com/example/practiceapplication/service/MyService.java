package com.example.practiceapplication.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

import java.util.Random;

public class MyService extends JobIntentService {
    private boolean mIsRandomNumberGenratorOn;
    private int mRandomNumber;
    private int MIN = 0;
    private int MAX = 100;

    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, MyService.class, 101, intent);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        startRandomNumberGenerator();
    }

    private void startRandomNumberGenerator() {
        for (int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(1000);
                mRandomNumber = new Random().nextInt(MAX) + MIN;
                Log.d("MainActivity", "Random Number :" + mRandomNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stopSelf();
    }

    private void stopRandomNumberGenerator() {
        mIsRandomNumberGenratorOn = false;
    }

    public int getmRandomNumber() {
        return mRandomNumber;
    }

    @Override
    public boolean onStopCurrentWork() {
        Log.d("MainActivity", "onStopCurrentWork: ");
        return super.onStopCurrentWork();
    }
}
