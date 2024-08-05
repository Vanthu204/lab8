package com.example.androidthi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Body;

import java.util.List;

public interface MotorcycleApi {
    @GET("motorcycles")
    Call<List<Motorcycle>> getMotorcycles();

    @GET("motorcycles/{id}")
    Call<Motorcycle> getMotorcycle(@Path("id") String id);

    @POST("motorcycles")
    Call<Motorcycle> createMotorcycle(@Body Motorcycle motorcycle);

}

