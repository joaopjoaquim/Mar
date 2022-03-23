package com.univ_amu.myapplication.data.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.univ_amu.myapplication.data.Place;

@androidx.room.Database(entities = {Place.class}, version = 5, exportSchema = false)
public abstract class Database extends RoomDatabase {
    private static volatile Database database = null;

    public static synchronized Database getInstance(Context context) {
        if (database==null) {
            database = Room.databaseBuilder(context.getApplicationContext(),
                    Database.class, "database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

    public abstract Dao dao();
}
