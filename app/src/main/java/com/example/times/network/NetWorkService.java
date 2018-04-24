package com.example.times.network;

import com.example.times.model.TopStoriesResp;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Karishma on 14/4/18.
 */

public interface NetWorkService  {

    @GET("topstories/v2/home.json")
    Observable<TopStoriesResp>
    getTopStories();
}
