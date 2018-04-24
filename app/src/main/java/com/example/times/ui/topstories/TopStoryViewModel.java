package com.example.times.ui.topstories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.times.App;
import com.example.times.di.component.DaggerRepositoryComp;
import com.example.times.model.TopStory;
import com.example.times.ui.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Karishma on 10/4/18.
 * View model or data handler of to story news.
 */

public class TopStoryViewModel extends BaseViewModel {

    @Inject
    TopStoriesRepository mRepo;

    private LiveData<List<TopStory>> topStories ;


    public TopStoryViewModel(@NonNull Application application) {
        super(application);
        DaggerRepositoryComp.builder().appComponent(((App)application).getComponent())
                .build().inject(this);
    }

    /**
     * getting top stories from repository
     * @return : live data containing top stories
     */
    public LiveData<List<TopStory>> getTopStories(){
        topStories = mRepo.getTopStories();
        if(topStories.getValue() == null){
            setIsLoading(true);
        }
        return topStories;
    }
}
