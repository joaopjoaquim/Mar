package com.univ_amu.myapplication.ui.placeList;

import android.app.Application;
import android.graphics.Bitmap;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.univ_amu.myapplication.data.Place;
import com.univ_amu.myapplication.data.Repository;

public class PlaceViewModel extends ViewModel {
    private final Repository repository;
    private final LiveData<Place> place;

    public PlaceViewModel(Application application, String code) {
        this.repository = new Repository(application);
        this.place = repository.getPlace(code);
    }

    public LiveData<Place> place() { return place; }

}