package com.example.times.ui.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableBoolean;
import android.support.annotation.NonNull;

/**
 * Created by Karishma on 10/4/18.
 */

public abstract class BaseViewModel extends AndroidViewModel {

    //status for showing progressbar
    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }
}
