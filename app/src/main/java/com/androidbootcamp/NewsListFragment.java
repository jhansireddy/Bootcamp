package com.androidbootcamp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.androidbootcamp.model.Tweet;
import com.androidbootcamp.util.DataProvider;
import com.androidbootcamp.util.TweetsListAdapter;

import java.util.List;

/**
 * Created by jhansirk on 1/15/16.
 */
public class NewsListFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_list, null);
        init();
        return view;
    }

    private void init() {
        ListView listView = (ListView) view.findViewById(R.id.listView);
        List<Tweet> tweets = DataProvider.getTweets();
        TweetsListAdapter adapter = new TweetsListAdapter(tweets, getActivity());
        listView.setAdapter(adapter);
    }

}