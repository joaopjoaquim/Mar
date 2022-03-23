package com.univ_amu.myapplication.ui.placeList;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.univ_amu.myapplication.data.Place;
import com.univ_amu.myapplication.databinding.PlaceItemBinding;

public class PlaceListAdapter extends ListAdapter<Place, PlaceListAdapter.ViewHolder> {

    PlaceListAdapter() {
        super(diffUtilCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = new TextView(parent.getContext());
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        PlaceItemBinding binding =PlaceItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Place place = getItem(position);
        holder.bind(place);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final PlaceItemBinding placeItemBinding;
        public Place place;

        public ViewHolder(PlaceItemBinding binding) {
            super(binding.getRoot());
            binding.setViewHolder(this);
            this.placeItemBinding = binding;

        }

        void bind(Place place) {
            this.place = place;
            this.placeItemBinding.invalidateAll();
        }

        public void onClick(View view) {
            NavDirections action = (NavDirections) PlaceListFragmentDirections.actionPlaceListFragmentToPlaceFragment(place.code);
            Navigation.findNavController(placeItemBinding.getRoot()).navigate(action);
        }

    }

    private static final DiffUtil.ItemCallback<Place> diffUtilCallback =
            new DiffUtil.ItemCallback<Place>() {
                @Override
                public boolean areItemsTheSame(Place oldPlace, Place newPlace) {
                    return oldPlace.code.equals(newPlace.code);
                }
                @Override
                public boolean areContentsTheSame(Place oldPlace, Place newPlace) {
                    return this.areItemsTheSame(oldPlace, newPlace);
                }
            };
}