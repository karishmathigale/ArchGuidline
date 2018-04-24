package com.example.times.model;

import java.util.ArrayList;

/**
 * Created by Karishma on 13/4/18.
 */

public class TopStoriesResp {
    private String status;
    private ArrayList<TopStory> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<TopStory> getResults() {
        return results;
    }

    public void setResults(ArrayList<TopStory> results) {
        this.results = results;
    }
}
