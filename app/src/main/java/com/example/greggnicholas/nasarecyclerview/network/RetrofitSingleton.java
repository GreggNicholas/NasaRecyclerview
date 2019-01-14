package com.example.greggnicholas.nasarecyclerview.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {


    private static Retrofit retroInstance;

    public static Retrofit getInstance() {

        if (retroInstance != null) {
            return retroInstance;
        }
        retroInstance = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retroInstance;

    }


    private RetrofitSingleton() {
    }
}
