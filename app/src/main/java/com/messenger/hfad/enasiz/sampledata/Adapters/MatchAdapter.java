package com.messenger.hfad.enasiz.sampledata.Adapters;

/**
 * Created by Nahom on 2018-03-26.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.messenger.hfad.enasiz.R;
import com.messenger.hfad.enasiz.sampledata.AppController;


import java.util.List;


import android.app.Activity;
import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.messenger.hfad.enasiz.R;
import com.messenger.hfad.enasiz.sampledata.Match;

import java.util.List;

public class MatchAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Match> matchItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public MatchAdapter(Activity activity, List<Match> matchItems) {
        this.activity = activity;
        this.matchItems = matchItems;
    }

    @Override
    public int getCount() {
        return matchItems.size();
    }

    @Override
    public Object getItem(int location) {
        return matchItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.my_listview_detail, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail_home = (NetworkImageView) convertView
                .findViewById(R.id.imageView);
        NetworkImageView thumbNail_away = (NetworkImageView) convertView
                .findViewById(R.id.imageView);
        TextView homeTeam = (TextView) convertView.findViewById(R.id.tv_hometeam);
        TextView awayteam = (TextView) convertView.findViewById(R.id.tv_awayteam);
        TextView competetiontype = (TextView) convertView.findViewById(R.id.tv_competetiontype);
        TextView starttime = (TextView) convertView.findViewById(R.id.tv_starttime);
        TextView endtime = (TextView) convertView.findViewById(R.id.tv_endtime);
        TextView oddshome = (TextView) convertView.findViewById(R.id.tv_oddshome);
        TextView oddsaway = (TextView) convertView.findViewById(R.id.tv_oddsaway);
        TextView venue = (TextView) convertView.findViewById(R.id.tv_venue);


        // getting movie data for the row
        Match m = matchItems.get(position);

        // thumbnail image
        thumbNail_home.setImageUrl(m.getThumbnail_home(), imageLoader);
        thumbNail_away.setImageUrl(m.getThumbnail_away(), imageLoader);

        // title
        homeTeam.setText(m.getHome_team());

        // rating
        awayteam.setText(String.valueOf(m.getAway_team()));
        competetiontype.setText(String.valueOf(m.getCompetition_type()));
        starttime.setText(String.valueOf(m.getStart_time()));
        endtime.setText(String.valueOf(m.getEnd_time()));
        oddshome.setText(String.valueOf(m.getWinning_odds_home()));
        oddsaway.setText(String.valueOf(m.getWinning_odds_away()));



        return convertView;
    }

}

