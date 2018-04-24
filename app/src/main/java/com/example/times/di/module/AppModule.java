package com.example.times.di.module;

import android.app.Application;
import android.content.Context;

import com.example.times.ui.detailtopstory.DetailStoryActivityComp;
import com.example.times.ui.topstories.TopStoryActivityComp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Karishma on 12/4/18.
 */

@Module(subcomponents = {TopStoryActivityComp.class, DetailStoryActivityComp.class})
public class AppModule {

    @Provides
    @Singleton
    Context getAppContext(Application application){
        return application;
    }

}
