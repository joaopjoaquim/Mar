package com.univ_amu.myapplication.data;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Place")
public class Place {
    public Place(String code, String name, String timeConsumption, double latitude, double longitude, String image) {
        this.code = code;
        this.name = name;
        this.timeConsumption = timeConsumption;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
    }

    @PrimaryKey
    @NonNull
    public String code;

    @NonNull
    public String name;

    @NonNull
    public String timeConsumption;

    @NonNull
    public double latitude;

    @NonNull
    public double longitude;

    public String image;

    public int imageId;

}
