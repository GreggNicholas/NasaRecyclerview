package com.example.greggnicholas.nasarecyclerview.view;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.example.greggnicholas.nasarecyclerview.R;
import com.example.greggnicholas.nasarecyclerview.controller.NasaAdapter;
import com.example.greggnicholas.nasarecyclerview.model.MarsRoverPhotos;
import com.example.greggnicholas.nasarecyclerview.network.NasaService;
import com.example.greggnicholas.nasarecyclerview.network.RetrofitSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Nasa: ";
    private static final String BASE_URL_NASA_API = "https://api.nasa.gov/";
    private NasaService nasaService;
    private ImageView marsView;
    private RecyclerView recyclerView;
    private NasaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        marsView = findViewById(R.id.nasa_image);
        recyclerView = findViewById(R.id.nasa_recyclerview);

        Retrofit retrofit = RetrofitSingleton.getInstance();

        final NasaService nasaService = retrofit.create(NasaService.class);


        Call<MarsRoverPhotos> marsPhotos = nasaService.getImgSrc();

        marsPhotos.enqueue(new Callback<MarsRoverPhotos>() {
            @Override
            public void onResponse(Call<MarsRoverPhotos> call, Response<MarsRoverPhotos> response) {
                Log.d(TAG, "onResponse: " + nasaService.getImgSrc());
                adapter = new NasaAdapter(getApplicationContext(), response.body().getImg_src());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
            }

            @Override
            public void onFailure(Call<MarsRoverPhotos> call, Throwable t) {
                Log.d("TAG", "onResponse: " + t.toString());
            }
        });

    }
}
