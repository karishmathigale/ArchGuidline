package com.example.times.di.component;

import com.example.times.di.RepoScope;
import com.example.times.di.module.RepoModule;
import com.example.times.ui.base.BaseViewModel;
import com.example.times.ui.topstories.TopStoryViewModel;

import dagger.Component;

/**
 * Created by Karishma on 17/4/18.
 */

@RepoScope
@Component(modules = RepoModule.class,dependencies = AppComponent.class)
public interface RepositoryComp {

    //NetworkClient getNetworkClient();

    void inject(BaseViewModel model);
    void inject(TopStoryViewModel model);


}
