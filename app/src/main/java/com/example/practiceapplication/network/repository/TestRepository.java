package com.example.practiceapplication.network.repository;

import com.example.practiceapplication.NetworkUtils.NetworkUtils;
import com.example.practiceapplication.network.api.TestAPI;

import java.util.ArrayList;

import retrofit2.Call;

public class TestRepository {
    private static TestRepository testRepository;
    private static TestAPI testAPI;

    public static TestRepository getInstance() {
        if (testRepository == null) {
            testRepository = new TestRepository();
        }
        return testRepository;
    }

    private TestRepository() {
        testAPI = NetworkUtils.createAPI("", TestAPI.class);
    }

    public Call<ArrayList<String>> getNotifications() {
        return testAPI.getNotifications();
    }
}
