package com.b8games.beatpug.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.b8games.beatpug.R;

/**
 * Created by monster on 28.11.2016.
 */


public class facebookactivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.facebookactivity, container, false);

        WebView wv = (WebView) view.findViewById(R.id.facebook_webview);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("file:///android_asset/facebook.html");
        return view;

    }

}