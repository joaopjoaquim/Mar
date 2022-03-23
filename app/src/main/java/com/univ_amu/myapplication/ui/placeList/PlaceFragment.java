package com.univ_amu.myapplication.ui.placeList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.univ_amu.myapplication.databinding.FragmentPlaceBinding;
import com.univ_amu.myapplication.ui.placeList.PlaceViewModel;
import com.univ_amu.myapplication.ui.placeList.PlaceViewModelFactory;

import java.util.Objects;

public class PlaceFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        FragmentPlaceBinding binding = FragmentPlaceBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        String code = PlaceFragmentArgs.fromBundle(getArguments()).getCode();

        PlaceViewModel model = ViewModelProviders.of(this,
                new PlaceViewModelFactory(getActivity().getApplication(), code)).get(PlaceViewModel.class);
        binding.setModel(model);
        return binding.getRoot();
    }
}
