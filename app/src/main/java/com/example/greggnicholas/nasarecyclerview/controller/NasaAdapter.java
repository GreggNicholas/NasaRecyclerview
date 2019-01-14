package com.example.greggnicholas.nasarecyclerview.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.greggnicholas.nasarecyclerview.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NasaAdapter extends RecyclerView.Adapter<NasaAdapter.NasaViewHolder> {
    private List<String> nasaPhotoList;
    private LayoutInflater layoutInflater;

    public NasaAdapter(Context applicationContext,List<String> nasaPhotoList) {
        this.nasaPhotoList = nasaPhotoList;
        this.layoutInflater = layoutInflater.from(applicationContext);
    }


    @NonNull
    @Override
    public NasaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = layoutInflater.inflate(R.layout.cardview_layout, viewGroup, false);
        return new NasaViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull NasaAdapter.NasaViewHolder nasaViewHolder, int position) {
        String current = nasaPhotoList.get(position);
        Picasso.get()
                .load(current)
                .into(nasaViewHolder.marsRoverView);
    }

    @Override
    public int getItemCount() {
        return nasaPhotoList.size();
    }

    public class NasaViewHolder extends RecyclerView.ViewHolder {
        private ImageView marsRoverView;
        private NasaAdapter adapter;

        public NasaViewHolder(@NonNull View itemView, NasaAdapter adapter) {
            super(itemView);
            marsRoverView = itemView.findViewById(R.id.nasa_image);
            this.adapter = adapter;
        }
    }
}
