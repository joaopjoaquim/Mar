package com.univ_amu.myapplication.ui.placeList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.univ_amu.myapplication.databinding.FragmentPlaceListBinding;

public class PlaceListFragment extends Fragment {

    private FragmentPlaceListBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPlaceListBinding.inflate(inflater, container, false);
        PlaceListViewModel model = ViewModelProviders.of(this).get(PlaceListViewModel.class);
        binding.setModel(model);
        PlaceListAdapter adapter = new PlaceListAdapter();
        model.places().observe(getViewLifecycleOwner(), adapter::submitList);
        binding.placeList.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}