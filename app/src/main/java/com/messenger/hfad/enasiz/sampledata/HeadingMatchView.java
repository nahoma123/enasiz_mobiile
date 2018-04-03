package com.messenger.hfad.enasiz.sampledata;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.messenger.hfad.enasiz.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.Collapse;
import com.mindorks.placeholderview.annotations.expand.Expand;
import com.mindorks.placeholderview.annotations.expand.Parent;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;
import com.mindorks.placeholderview.annotations.expand.SingleTop;
import com.mindorks.placeholderview.annotations.expand.Toggle;

import java.util.Date;

/**
 * Created by Nahom on 2018-03-26.
 */
@Parent
@SingleTop
@Layout(R.layout.match_group)
public class HeadingMatchView {

    @View(R.id.tv_date)
    private TextView mdate;

    @View(R.id.tv_starttime)
    private TextView mstart_time;

    @View(R.id.tv_endtime)
    private TextView mend_time;

    @View(R.id.tv_hometeam)
    private TextView mhome_time;

    @View(R.id.tv_awayteam)
    private TextView mawayteam;

    @View(R.id.toggleIcon1)
    private ImageView toggleIcon;

    @Toggle(R.id.l_match_heading)
    private LinearLayout toggleView;


    @Toggle(R.id.tv_competition)
    private TextView mcompetitionType;

    @Toggle(R.id.tv_venue)
    private TextView mvenue;


    @ParentPosition
    private int mParentPosition;

    private Context mContext;

    private String date,starttime,endtime,hometeam,awayteam,competition,venue;

    public HeadingMatchView(Context context, String dateC, String starttimeC,String endtimeC,String hometeamC, String awayteamC, String competitionC, String venueC) {
        mContext = context;
        date = dateC;
        starttime = starttimeC;
        endtime = endtimeC;
        hometeam = hometeamC;
        awayteam = awayteamC;
        competition = competitionC;
        venue = venueC;

    }

    @Resolve
    private void onResolved() {
        toggleIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_menu_send));

        mdate.setText(date);
        mstart_time.setText(starttime);
        mend_time.setText(endtime);
        mhome_time.setText(hometeam);
        mawayteam.setText(awayteam);
        mcompetitionType.setText(competition);
        mvenue.setText(venue);
    }

    @Expand
    private void onExpand(){
        toggleIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_menu_send));
    }

    @Collapse
    private void onCollapse(){
        toggleIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_menu_send));
    }




//
//    @SerializedName("id")
//    @Expose
//    public int id;
//
//    @SerializedName("competition_type")
//    @Expose
//    public String competition_type;
//
//    @SerializedName("competition_id")
//    @Expose
//    private int competition_id;
//
//    @SerializedName("home_team")
//    @Expose
//    private int home_team;
//
//    @SerializedName("away_team")
//    @Expose
//    private int away_team;
//
//    @SerializedName("start_time")
//    @Expose
//    private Date start_time;
//
//    @SerializedName("end_time")
//    @Expose
//    private Date end_time;
//
//    @SerializedName("match_status")
//    @Expose
//    private String match_status;
//
//    @SerializedName("venue")
//    @Expose
//    private String venue;
//
//    public String getThumbnail_home() {
//        return thumbnail_home;
//    }
//
//    public void setThumbnail_home(String thumbnail_home) {
//        this.thumbnail_home = thumbnail_home;
//    }
//
//    public String getThumbnail_away() {
//        return thumbnail_away;
//    }
//
//    public void setThumbnail_away(String thumbnail_away) {
//        this.thumbnail_away = thumbnail_away;
//    }
//
//    private String thumbnail_home;
//    private String thumbnail_away;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getCompetition_type() {
//        return competition_type;
//    }
//
//    public void setCompetition_type(String competition_type) {
//        this.competition_type = competition_type;
//    }
//
//    public int getCompetition_id() {
//        return competition_id;
//    }
//
//    public void setCompetition_id(int competition_id) {
//        this.competition_id = competition_id;
//    }
//
//    public int getHome_team() {
//        return home_team;
//    }
//
//    public void setHome_team(int home_team) {
//        this.home_team = home_team;
//    }
//
//    public int getAway_team() {
//        return away_team;
//    }
//
//    public void setAway_team(int away_team) {
//        this.away_team = away_team;
//    }
//
//    public Date getStart_time() {
//        return start_time;
//    }
//
//    public void setStart_time(Date start_time) {
//        this.start_time = start_time;
//    }
//
//    public Date getEnd_time() {
//        return end_time;
//    }
//
//    public void setEnd_time(Date end_time) {
//        this.end_time = end_time;
//    }
//
//    public String getMatch_status() {
//        return match_status;
//    }
//
//    public void setMatch_status(String match_status) {
//        this.match_status = match_status;
//    }
//
//    public String getVenue() {
//        return venue;
//    }
//
//    public void setVenue(String venue) {
//        this.venue = venue;
//    }
}
