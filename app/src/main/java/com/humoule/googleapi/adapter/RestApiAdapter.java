package com.humoule.googleapi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.humoule.googleapi.task.GetAddress;
import com.humoule.googleapi.util.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Farouk Touzi on 03/05/16.
 */
public class RestApiAdapter {

    private static Retrofit sharedInstance = null;

    public static HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    public static OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(logging)
            .build();

    public static Retrofit getInstance() {
        if (sharedInstance == null) {

            sharedInstance = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return sharedInstance;
    }

    private static final GetAddress service = getInstance().create(GetAddress.class);

    public static GetAddress getService() {
        return service;
    }

}