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
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.messenger.hfad.enasiz.R;
import com.messenger.hfad.enasiz.sampledata.AppController;


import java.util.HashMap;
import java.util.List;


import com.messenger.hfad.enasiz.sampledata.Match;

public class MatchAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private LayoutInflater inflater;
    private List<Match> _matchHeader;
    private HashMap<Match,List<Match>> _listDataChild;

    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public MatchAdapter(Context _context, List<Match> matchheader,HashMap<Match,List<Match>> listChildData) {
        this._context = _context;
        this._matchHeader = matchheader;
        this._listDataChild = listChildData;
    }
    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._matchHeader.get(groupPosition))
                .get(childPosititon);
    }

    /**
     * This is what makes the parent to view
     * @param i
     * @param b
     * @param convertView
     * @param parent
     * @return
     */
    public View getGroupView(int i, boolean b, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.match_group, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
//        NetworkImageView thumbNail_home = (NetworkImageView) convertView
//                .findViewById(R.id.imageView);
//        NetworkImageView thumbNail_away = (NetworkImageView) convertView
//                .findViewById(R.id.imageView2);
        TextView homeTeam = (TextView) convertView.findViewById(R.id.tv_hometeam);
        TextView awayteam = (TextView) convertView.findViewById(R.id.tv_awayteam);
        TextView competetiontype = (TextView) convertView.findViewById(R.id.tv_competition);
        TextView starttime = (TextView) convertView.findViewById(R.id.tv_starttime);
        TextView endtime = (TextView) convertView.findViewById(R.id.tv_endtime);
        TextView date = (TextView) convertView.findViewById(R.id.tv_date);

//        TextView oddshome = (TextView) convertView.findViewById(R.id.);
//        TextView oddsaway = (TextView) convertView.findViewById(R.id.tv_oddsaway);
        TextView venue = (TextView) convertView.findViewById(R.id.tv_venue);


        // getting movie data for the row
        Match m = (Match)getGroup(i);

        // thumbnail image
//        thumbNail_home.setImageUrl(m.getThumbnail_home(), imageLoader);
//        thumbNail_away.setImageUrl(m.getThumbnail_away(), imageLoader);

        // title
        homeTeam.setText(m +"");

        // rating
//        awayteam.setText(String.valueOf(m.getAway_team()));
        competetiontype.setText(String.valueOf(m.getCompetition_type()));
        starttime.setText(String.valueOf(m.getStart_time()));
        endtime.setText(String.valueOf(m.getEnd_time()));
//        oddshome.setText(String.valueOf(m.getWinning_odds_home()));
//        oddsaway.setText(String.valueOf(m.getWinning_odds_away()));



        return convertView;
    }

    /**
     * This is what makes the child to view
     * @param groupPosition
     * @param childPosition
     * @return
     */
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.match_list_detail, null);
        }

        return convertView;
    }



    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._matchHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._matchHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._matchHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}