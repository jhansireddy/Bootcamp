package com.androidbootcamp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.androidbootcamp.task.TwitterAsynTask;
import com.androidbootcamp.util.TweetsListAdapter;

import java.util.List;

import twitter4j.Status;

/**
 * Created by jhansirk on 1/15/16.
 */
public class NewsListFragment extends Fragment implements TweetsReceiver {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_list, null);
        init();
        return view;
    }

    private void renderData(List<twitter4j.Status> statuses) {
        ListView listView = (ListView) view.findViewById(R.id.listView);
        TweetsListAdapter adapter = new TweetsListAdapter(statuses, getActivity());
        listView.setAdapter(adapter);
    }

    private void init() {
        new TwitterAsynTask(this).execute();
    }

    @Override
    public void onTweetsRecieved(List<Status> statuses) {
        if (statuses != null) {
            renderData(statuses);
        }
    }
}

