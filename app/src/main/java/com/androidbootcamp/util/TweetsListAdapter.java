package com.androidbootcamp.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidbootcamp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import twitter4j.Status;

public class TweetsListAdapter extends BaseAdapter {
    private List<Status> statuses;
    private Context context;
    private LayoutInflater inflater;

    public TweetsListAdapter(List<Status> statuses, Context context) {
        this.statuses = statuses;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return statuses.size();
    }

    @Override
    public Object getItem(int position) {
        return statuses.get(position);
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
        Status status = (Status) getItem(position);
        if (convertView == null) {
            convertView = createView();
        }
        updateViewHolder(convertView, status);
        return convertView;
    }

    private void updateViewHolder(View convertView, Status status) {
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        Picasso.with(context).load(DataProvider.getIconUrl()).into(viewHolder.tweetIcon);
        viewHolder.tweetMessage.setText(status.getText());
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
