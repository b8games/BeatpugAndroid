package com.b8games.beatpug.activities;

import android.app.Application;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

/**
 * Created by cspr on 29.11.2016.
 */

public class TimeLineFabricApplication extends Application{

    private static final String TWITTER_KEY = "YKzQOUApgOh6nH56TbGivby6J";
    private static final String TWITTER_SECRET = "vX7GoLQEdRKeGpQa8ZUsP03t3hvOLqS7wlOLUXYM9yQohAwZTK";

    @Override
    public void onCreate() {
        super.onCreate();

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));

    }
}
