package com.b8games.beatpug.activities;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.b8games.beatpug.R;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

import io.fabric.sdk.android.Fabric;

/**
 * Created by monster on 29.11.2016.
 */

public class SearchTimelineFragment extends ListFragment {
    private static final String TWITTER_KEY = "YKzQOUApgOh6nH56TbGivby6J";
    private static final String TWITTER_SECRET = "vX7GoLQEdRKeGpQa8ZUsP03t3hvOLqS7wlOLUXYM9yQohAwZTK";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(getActivity(), new Twitter(authConfig));


        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("fratalbayram")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getActivity())
                .setTimeline(userTimeline)
                .build();
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.timelineactivity, container, false);
    }
}