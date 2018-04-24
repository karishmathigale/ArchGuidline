package com.example.times.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.times.model.TopStory;

/**
 * Created by Karishma on 17/4/18.
 */

@Database(entities = TopStory.class,version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase{

    public abstract TopStoryDao getTopStoryDao();
}
