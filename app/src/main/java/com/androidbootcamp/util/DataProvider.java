package com.androidbootcamp.util;

import com.androidbootcamp.model.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhansirk on 1/15/16.
 */
public class DataProvider {

    public static List<String> getNews()
    {
        List<String> news = new ArrayList<>();
        news.add("Heavy Rains in Chennai");
        news.add("Kohinoor in salarjung museum");
        news.add("Roja suspended from assembly for an year");
        news.add("Missing flight found to be landed in Kerala");
        news.add("Will Modi win this time");
        news.add("Rupee value is more than dollar now");
        news.add("Coders are not programmers");
        news.add("Stay Foolish, Stay Hungry");
        news.add("iPhone 7 record sales");
        news.add("Google's biggest campus in Hyderabad");
        news.add("Subway track from Kerala to Delhi");
        return news;
    }

    public static List<Tweet> getTweets() {
        List<Tweet> tweets = new ArrayList<>();
        tweets.add(new Tweet("Heavy Rains in Chennai", ""));
        tweets.add(new Tweet("Kohinoor in salarjung museum", ""));
        tweets.add(new Tweet("Roja suspended from assembly for an year", ""));
        tweets.add(new Tweet("Missing flight found to be landed in Kerala", ""));
        tweets.add(new Tweet("Will Modi win this time", ""));
        tweets.add(new Tweet("Rupee value is more than dollar now", ""));
        tweets.add(new Tweet("Coders are not programmers", ""));
        tweets.add(new Tweet("Stay Foolish, Stay Hungry", ""));
        tweets.add(new Tweet("iPhone 7 record sales", ""));
        tweets.add(new Tweet("Google's biggest campus in Hyderabad", ""));
        tweets.add(new Tweet("Subway track from Kerala to Delhi", ""));
        return tweets;
    }

}
