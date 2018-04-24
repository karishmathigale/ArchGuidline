package com.example.times.db;

import android.arch.persistence.room.TypeConverter;

import com.example.times.model.Multimedia;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Karishma on 18/4/18.
 */

public class Converters {
    @TypeConverter
    public static ArrayList<Multimedia> fromString(String value) {
        Type listType = new TypeToken<ArrayList<Multimedia>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<Multimedia> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
