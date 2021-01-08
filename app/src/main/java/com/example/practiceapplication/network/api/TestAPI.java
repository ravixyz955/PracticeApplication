package com.example.practiceapplication.network.api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TestAPI {

    String CONTEXT = "/api/v1";

    @GET(CONTEXT + "/notifications")
    Call<ArrayList<String>> getNotifications();
}
