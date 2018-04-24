package com.example.times.di;

import android.app.Activity;

import com.example.times.ui.detailtopstory.DetailStoryActivity;
import com.example.times.ui.detailtopstory.DetailStoryActivityComp;
import com.example.times.ui.topstories.TopStoryActivity;
import com.example.times.ui.topstories.TopStoryActivityComp;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Karishma on 12/4/18.
 */

@Module
public abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(TopStoryActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(TopStoryActivityComp.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(DetailStoryActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindDetailStoryActivity(DetailStoryActivityComp.Builder builder);
}
