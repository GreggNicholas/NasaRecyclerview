package com.example.greggnicholas.nasarecyclerview.network;

import com.example.greggnicholas.nasarecyclerview.model.EarthDate;
import com.example.greggnicholas.nasarecyclerview.model.MarsRoverPhotos;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NasaService {

    @GET("  mars-photos/api/v1/rovers/curiosity/photos")
    Call<MarsRoverPhotos> getImgSrc();

    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    Call<EarthDate> getEarthDate();


}
