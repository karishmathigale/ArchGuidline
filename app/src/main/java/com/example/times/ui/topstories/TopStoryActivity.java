package com.example.times.ui.topstories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.times.BR;
import com.example.times.R;
import com.example.times.databinding.ActivityTopStoryBinding;
import com.example.times.model.TopStory;
import com.example.times.ui.base.BaseActivity;
import com.example.times.ui.detailtopstory.DetailStoryActivity;
import com.example.times.utils.Constants;

import java.util.ArrayList;

/**
 * This class shows top stories
 */
public class TopStoryActivity extends BaseActivity<ActivityTopStoryBinding, TopStoryViewModel> implements TopStoryAdapter.OnItemClickListener {

    private ArrayList<TopStory> topStories;
    private TopStoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setAdapter();

        //observe live data emitted by room database i.e. observe top stories
        mViewModel.getTopStories().observe(this, object -> {

            if (object != null) {

                topStories = (ArrayList<TopStory>) object;

                if(mViewDataBinding.progressBar.getVisibility() == View.VISIBLE && topStories.size() != 0 ){
                    mViewModel.setIsLoading(false);
                }
                adapter.addStories(topStories);
            }
        });
    }

    /**
     * set adapter to to stories recycler view
     */
    private void setAdapter() {
        adapter = new TopStoryAdapter(topStories);
        mViewDataBinding.rvStories.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_top_story;
    }

    @Override
    public Class<TopStoryViewModel> getViewModelType() {
        return TopStoryViewModel.class;
    }

    /**
     * start detail story activity
     * @param position : position on news
     */
    @Override
    public void onClickListener(int position) {
        Intent intent = new Intent(this, DetailStoryActivity.class);
        intent.putExtra(Constants.URL, topStories.get(position).getUrl());
        startActivity(intent);
    }
}
