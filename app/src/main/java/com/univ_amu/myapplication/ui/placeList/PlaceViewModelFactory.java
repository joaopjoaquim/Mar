package com.univ_amu.myapplication.ui.placeList;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class PlaceViewModelFactory implements ViewModelProvider.Factory {
    private final Application application;
    private final String code;

    public PlaceViewModelFactory(Application application, String code) {
        this.application = application;
        this.code = code;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PlaceViewModel.class)) {
            return (T) new PlaceViewModel(application, code);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}