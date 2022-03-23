package com.univ_amu.myapplication.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.univ_amu.myapplication.data.Place;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Query("SELECT * FROM Place ORDER BY name")
    LiveData<List<Place>> getPlaces();

    @Query("SELECT * FROM Place WHERE code = :code")
    LiveData<Place> getPlace(String code);

    @Query("SELECT count(code) FROM Place")
    LiveData<Integer> getPlaceCount();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPlace(Place place);
}
