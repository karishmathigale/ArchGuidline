package com.example.times.network;

import android.content.Context;

import com.example.times.ui.topstories.TopStoriesRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Karishma on 14/4/18.
 */

public class NetworkClient extends BaseNetworkClient{

    private NetWorkService mNetWorkService;

    public NetworkClient(Context context, NetWorkService service) {
        super(context);
        mNetWorkService = service;
    }

    public Disposable getTopStories(TopStoriesRepository mainViewModel) {
        return mNetWorkService
                .getTopStories()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(mainViewModel::handleGetTopStoriesResp, this::handleError);

    }
}
