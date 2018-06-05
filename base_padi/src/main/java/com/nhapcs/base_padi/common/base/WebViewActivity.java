package com.nhapcs.base_padi.common.base;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.nhapcs.base_padi.R;
import com.nhapcs.base_padi.common.mvp.activity.MVPActivity;
import com.nhapcs.base_padi.common.utils.StringUtil;
import com.nhapcs.base_padi.common.view.ValueProgressBar;

/**
 * Created by Nha Nha on 9/18/2017.
 */

public abstract class WebViewActivity extends MVPActivity {

    WebView mWebView;
    ValueProgressBar mProgressLoading;

    protected abstract String getUrl();

    @Override
    protected int getContentView() {
        return R.layout.act_webview;
    }

    @Override
    protected void initView() {
        mWebView = findViewById(R.id.web_view);
        mProgressLoading = mWebView.findViewById(R.id.progressBar);
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //  mProgressBar.setVisibility(View.GONE);
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    mProgressLoading.setVisibility(View.GONE);
                    mProgressLoading.setProgress(100);
                } else {
                    mProgressLoading.setVisibility(View.VISIBLE);
                    // will update the "progress" propriety of seekbar until it reaches progress
                    ObjectAnimator animation = ObjectAnimator.ofInt(mProgressLoading, "progress", newProgress);
                    animation.setDuration(500); // 0.5 second
                    animation.setInterpolator(new DecelerateInterpolator());
                    animation.start();
                }
            }
        });
        WebSettings settings = mWebView.getSettings();
        enableJavaScript();
        settings.setLoadsImagesAutomatically(true);
        if (!StringUtil.isEmpty(getUrl()))
            mWebView.loadUrl(getUrl());
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void enableJavaScript() {
        mWebView.getSettings().setJavaScriptEnabled(true);
    }

}
