package com.example.metromate;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MetroApi {
    private static Retrofit retrofit;
    private static String BASE_URL = "https://us-central1-delhimetroapi.cloudfunctions.net/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
