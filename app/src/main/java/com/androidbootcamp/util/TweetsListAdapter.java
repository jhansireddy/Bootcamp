package com.androidbootcamp.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidbootcamp.R;
import com.androidbootcamp.model.Tweet;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TweetsListAdapter extends BaseAdapter{
    private List<Tweet> tweets;
    private Context context;
    private LayoutInflater inflater;

    public TweetsListAdapter(List<Tweet> tweets, Context context) {
        this.tweets = tweets;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return tweets.size();
    }

    @Override
    public Object getItem(int position) {
        return tweets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView tweetMessage;
        ImageView tweetIcon;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tweet tweet = (Tweet) getItem(position);
        if (convertView == null) {
            convertView = createView();
        }
        updateViewHolder(convertView, tweet);
        return convertView;
    }

    private void updateViewHolder(View convertView, Tweet tweet) {
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(viewHolder.tweetIcon);
        viewHolder.tweetMessage.setText(tweet.getMessage());
    }

    private View createView() {
        View view = inflater.inflate(R.layout.tweets_list_item, null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tweetIcon = (ImageView) view.findViewById(R.id.tweetIcon);
        viewHolder.tweetMessage = (TextView) view.findViewById(R.id.tweetMsg);
        view.setTag(viewHolder);
        return view;
    }

}
