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


        WebView wv_video = (WebView) view.findViewById(R.id.canliyayinwebview);
        wv_video.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        wv_video.getSettings().setJavaScriptEnabled(true);
        wv_video.setWebChromeClient(new WebChromeClient());

        final String mimeType = "text/html";
        final String encoding = "UTF-8";

        String html = getHTMLTwitch();

        wv_video.loadDataWithBaseURL("", html, mimeType, encoding, "");
        return view;


    }

    public String getHTMLTwitch() {
        String html = "<html><body style='margin:0;padding:0;'>" +
                "<iframe src=\"http://twitch.tv/jahrein/embed\" height=\"100%\" width=\"100%\" type=\"text/html\"></iframe>" +
                "</body></html>\n";

        return html;
    }

}