package com.example.metromate;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {

    @GET("route-get?from=Dwarka&to=Palam")
    Call<Model> getAllData();
}
