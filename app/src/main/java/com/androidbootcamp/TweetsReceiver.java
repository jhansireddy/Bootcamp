package com.androidbootcamp;

import java.util.List;

import twitter4j.Status;

public interface TweetsReceiver {

    void onTweetsRecieved(List<Status> statuses);
}
