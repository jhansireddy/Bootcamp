package com.androidbootcamp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidbootcamp.util.DataProvider;

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
        List<String> news = DataProvider.getNews();
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, news);
        listView.setAdapter(adapter);
    }

}
