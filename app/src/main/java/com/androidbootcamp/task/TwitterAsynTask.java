package com.androidbootcamp.task;

import android.os.AsyncTask;

import com.androidbootcamp.TweetsReceiver;
import com.androidbootcamp.util.TwitterService;

import java.util.List;

public class TwitterAsynTask extends AsyncTask<Void, Void, List<twitter4j.Status>> {

    private TweetsReceiver tweetsReceiver;

    public TwitterAsynTask(TweetsReceiver tweetsReceiver) {
        this.tweetsReceiver = tweetsReceiver;
    }

    @Override
    protected List<twitter4j.Status> doInBackground(Void... params) {
        return TwitterService.getTimeLineStatuses();
    }

    @Override
    protected void onPostExecute(List<twitter4j.Status> statuses) {
        super.onPostExecute(statuses);
        tweetsReceiver.onTweetsRecieved(statuses);
    }
}