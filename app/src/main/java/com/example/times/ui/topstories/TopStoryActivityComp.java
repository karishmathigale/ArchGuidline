package com.example.times.ui.topstories;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Karishma on 13/4/18.
 */
@Subcomponent(modules = TopStoryModule.class)
public interface TopStoryActivityComp extends AndroidInjector<TopStoryActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TopStoryActivity>{}

}
