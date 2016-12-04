package com.b8games.beatpug.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.b8games.beatpug.R;
import com.github.rtoshiro.view.video.FullscreenVideoLayout;

import java.io.IOException;

/**
 * Created by monster on 2.12.2016.
 */

public class videoizle extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoizle);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        String videourl = getIntent().getExtras().getString("videourl");



        FullscreenVideoLayout videoLayout;

        videoLayout = (FullscreenVideoLayout) findViewById(R.id.videoizle);
        videoLayout.setActivity(this);


        Uri videoUri = Uri.parse(videourl);
        try {
            videoLayout.setVideoURI(videoUri);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
