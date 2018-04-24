package com.example.times.ui.detailtopstory;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Karishma on 17/4/18.
 */
@Subcomponent(modules = DetailStoryModule.class)
public interface DetailStoryActivityComp extends AndroidInjector<DetailStoryActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DetailStoryActivity>{}
}
