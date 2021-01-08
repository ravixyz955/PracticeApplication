package com.example.practiceapplication.NetworkUtils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtils {
    private static OkHttpClient.Builder okHttpClient;

    private static GsonBuilder gsonBuilder;

    private static Retrofit provideRetrofit(String URL) {
        return new Retrofit.Builder()
                .client(provideOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(provideGson()))
                .baseUrl(URL)
                .build();
    }

    private static Gson provideGson() {
        if (gsonBuilder == null) {
            gsonBuilder = new GsonBuilder();
        }
        gsonBuilder.setLenient();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return gsonBuilder.create();
    }

    private static OkHttpClient provideOkHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder();
        }
        okHttpClient.connectTimeout(2, TimeUnit.MINUTES);
        okHttpClient.readTimeout(2, TimeUnit.MINUTES);
        okHttpClient.protocols(Collections.singletonList(Protocol.HTTP_1_1));
        okHttpClient.addInterceptor(null);
        okHttpClient.authenticator(null);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient.addInterceptor(httpLoggingInterceptor);

        return okHttpClient.build();
    }

    public static <S> S createAPI(String URL, Class<S> serviceClass) {
        return provideRetrofit(URL).create(serviceClass);
    }
}
