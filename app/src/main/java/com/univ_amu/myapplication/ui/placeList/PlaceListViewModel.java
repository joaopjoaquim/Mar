package com.univ_amu.myapplication.ui.placeList;

import android.app.Application;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.univ_amu.myapplication.data.Place;
import com.univ_amu.myapplication.data.Repository;

import java.util.List;

public class PlaceListViewModel extends AndroidViewModel {
    private final Repository repository;
    private final LiveData<List<Place>> places;

    public PlaceListViewModel(Application application) {
        super(application);
        this.repository = new Repository(application);
        this.places = repository.getPlaces();
    }

    public LiveData<List<Place>> places() { return places; }

    public void onSearch(View view){
        Log.i("FOOD SCANNER", "onSearch");
    }
}
