package com.univ_amu.myapplication.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.lifecycle.LiveData;

import com.univ_amu.myapplication.R;
import com.univ_amu.myapplication.data.database.Dao;
import com.univ_amu.myapplication.data.database.Database;
import com.univ_amu.myapplication.data.Place;
import com.univ_amu.myapplication.data.database.PlaceData;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {

    private final Context context;
    private final ExecutorService executor;
    private Dao dao;

    public Repository(Context context) {
        this.context = context;
        this.dao = null;
        executor = Executors.newSingleThreadExecutor();
        this.addPlacesIfEmpty();
        this.convertImageToId();
    }

    private Dao dao() {
        if (dao == null) {
            Database database = Database.getInstance(context);
            this.dao = database.dao();
        }
        return this.dao;
    }

    public LiveData<List<Place>> getPlaces() {
        return dao().getPlaces();
    }

    public LiveData<Integer> getPlaceCount() {
        return dao().getPlaceCount();
    }

    public LiveData<Place> getPlace(String code) {
        return dao().getPlace(code);
    }

    public void insertPlace(Place place) {
        executor.execute(() -> dao().insertPlace(place));
    }

    public void addPlacesIfEmpty() {
        getPlaceCount().observeForever(value -> {
            if (value != 0) return;
            for (Place place : PlaceData.populatePlacesData()) {
                insertPlace(place);
            }
        });
    }

    public void convertImageToId() {
            Place place = PlaceData.populatePlacesData()[0];
            String imageName = place.image;
            if (imageName.equals(""))
                return;
            int id = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
            place.imageId = id;
    }
}