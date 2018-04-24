package com.example.times.ui.topstories;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.times.db.TopStoryDao;
import com.example.times.model.TopStoriesResp;
import com.example.times.model.TopStory;
import com.example.times.network.NetworkClient;
import com.example.times.utils.Constants;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Karishma on 18/4/18.
 */

public class TopStoriesRepository {
    private TopStoryDao mDao;
    private NetworkClient mClient;

    @Inject
    public TopStoriesRepository(TopStoryDao mDao, NetworkClient mClient) {
        this.mDao = mDao;
        this.mClient = mClient;
    }

    /**
     * Get top stories api call
     * @return meanwhile return data present in database i.e. Live Data
     */
    public LiveData<List<TopStory>> getTopStories(){
        refreshStories();
        return mDao.getAllStories();
    }

    /**
     * Api call for get top stories
     */
    private void refreshStories() {
        mClient.getTopStories(this);
    }

    /**
     * save response of get top story api into database
     * @param topStoriesResp
     */
    public void handleGetTopStoriesResp(TopStoriesResp topStoriesResp) {
        if(topStoriesResp.getStatus().equals(Constants.STATUS_OK)){

            new AsyncTask<Void,Void,Integer>(){

                @Override
                protected Integer doInBackground(Void... voids) {
                    mDao.insertAll(topStoriesResp.getResults());
                    return null;
                }

            }.execute();
        }
    }
}
