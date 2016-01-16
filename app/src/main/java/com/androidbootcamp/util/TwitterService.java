package com.androidbootcamp.util;

import android.util.Log;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterService {

    public static List<Status> getTimeLineStatuses() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("WBU9LTgbgFnrZPbpKwhQoZlOu")
                .setOAuthConsumerSecret("RSqdS8r6sZJI0Rp3gD1a4BSxXmxYVJCwFqvQ8Cjp3n2XoD2kZa")
                .setOAuthAccessToken("140479371-aKq4F3sUrloDoqHAe1LbNs1FS8VFgoIwuX6tX6cB")
                .setOAuthAccessTokenSecret("07FLNfTvtzu4p0ET2jzf6ImiDdRvUVMKrAILhkUsA22Fi");
        TwitterFactory tf = new TwitterFactory(cb.build());

        Twitter twitter = tf.getInstance();
        try {
            List<twitter4j.Status> statuses = twitter.getHomeTimeline();
            Log.e("twitter:", statuses.toString());
            if (statuses != null && !statuses.isEmpty()) {
                return statuses;
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }
}
