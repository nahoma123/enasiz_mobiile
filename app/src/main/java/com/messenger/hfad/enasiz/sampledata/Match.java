package com.messenger.hfad.enasiz.sampledata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nahom on 2018-04-01.
 */

public class Match {

    @SerializedName("competition_type")
    @Expose
    private String competition_type;

    @SerializedName("start_time")
    @Expose
    private String start_time;


    @SerializedName("end_time")
    @Expose

    private String end_time;

    @SerializedName("match_status")
    @Expose
    private String match_status;

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @SerializedName("venue")
    @Expose

    private String venue;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    @SerializedName("updated_at")
    @Expose
    private String updated_at;

    @SerializedName("awayteam")
    @Expose
    private List<Team> awayteam;

    @SerializedName("hometeam")
    @Expose
    private List<Team> hometeam;

    @SerializedName("competition")
    @Expose
    private Competition competition;

    @SerializedName("bets")
    @Expose
    private List<Bet> bets;

    public String getCompetition_type() {
        return competition_type;
    }

    public void setCompetition_type(String competition_type) {
        this.competition_type = competition_type;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getMatch_status() {
        return match_status;
    }

    public void setMatch_status(String match_status) {
        this.match_status = match_status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public List<Team> getAwayteam() {
        return awayteam;
    }

    public void setAwayteam(List<Team> awayteam) {
        this.awayteam = awayteam;
    }

    public List<Team> getHometeam() {
        return hometeam;
    }

    public void setHometeam(List<Team> hometeam) {
        this.hometeam = hometeam;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

}
