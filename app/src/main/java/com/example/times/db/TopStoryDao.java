package com.example.times.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.times.model.TopStory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karishma on 17/4/18.
 */

@Dao
public interface TopStoryDao {
    @Query("SELECT * FROM TopStory")
    LiveData<List<TopStory>> getAllStories();

    @Insert
    void insertAll(ArrayList<TopStory> users);
}
