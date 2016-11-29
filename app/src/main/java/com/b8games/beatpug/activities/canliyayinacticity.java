package com.b8games.beatpug.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.b8games.beatpug.R;

/**
 * Created by monster on 28.11.2016.
 */


public class canliyayinacticity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.canliyayinactivity, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.dummyfrag_scrollableview);

        String url = "http://player.twitch.tv/?channel=jahrein";
        WebView mWebView;
        mWebView = (WebView) view.findViewById(R.id.canliyayinwebview);
        mWebView.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        mWebView.loadUrl(url);
        return view;
    }



}