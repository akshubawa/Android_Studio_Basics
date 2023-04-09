package com.example.metromate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MetroApi {
    private static Retrofit retrofit;
    private static String BASE_URL = "https://us-central1-delhimetroapi.cloudfunctions.net/";

    public static Retrofit getRetrofitInstance(String encodedFrom, String encodedTo) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        // Create Methods instance with encodedFrom and encodedTo strings
        Methods methods = retrofit.create(Methods.class);
        Call<Model> call = methods.getAllData(encodedFrom, encodedTo);

        // Enqueue the call and handle the response in the callback methods
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                // Handle response here
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                // Handle failure here
            }
        });

        return retrofit;
    }
}
