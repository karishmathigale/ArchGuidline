package com.example.times;

import android.app.Activity;
import android.app.Application;

import com.example.times.di.component.AppComponent;
import com.example.times.di.component.DaggerAppComponent;
import com.facebook.drawee.backends.pipeline.Fresco;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


/**
 * Created by karishma on 12/4/18.
 */

public class App extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
        mComponent = DaggerAppComponent.builder()
                .application(this)
                .build();

                mComponent.inject(this);

    }

    public AppComponent getComponent() {
        return mComponent;
    }
}
