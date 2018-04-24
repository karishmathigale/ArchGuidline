package com.example.times.ui.detailtopstory;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.times.BR;
import com.example.times.R;
import com.example.times.databinding.ActivityDetailStoryBinding;
import com.example.times.ui.base.BaseActivity;
import com.example.times.utils.Constants;

/**
 * Created by Karishma
 * This class showing detail of top story news
 */
public class DetailStoryActivity extends BaseActivity<ActivityDetailStoryBinding, DetailStoryViewModel> {

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail_story;
    }

    @Override
    public Class<DetailStoryViewModel> getViewModelType() {
        return DetailStoryViewModel.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewDataBinding.webview.getSettings().setJavaScriptEnabled(true);

        mViewDataBinding.webview.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                hideProgress();
            }
        });

        if (getIntent().getExtras() != null) {
            showProgress();
            mViewDataBinding.webview.loadUrl(getIntent().getStringExtra(Constants.URL));
        }
    }
}
