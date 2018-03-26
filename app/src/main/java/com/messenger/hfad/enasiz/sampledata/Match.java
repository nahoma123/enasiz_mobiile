package com.messenger.hfad.enasiz.sampledata;

import java.util.Date;

/**
 * Created by Nahom on 2018-03-26.
 */

public class Match {
    public int id;
    public String competition_type;
    private int competition_id;
    private int home_team;
    private int away_team;
    private Date start_time;
    private Date end_time;
    private Double winning_odds_home;
    private Double winning_odds_away;
    private String match_status;
    private String venue;

    public String getThumbnail_home() {
        return thumbnail_home;
    }

    public void setThumbnail_home(String thumbnail_home) {
        this.thumbnail_home = thumbnail_home;
    }

    public String getThumbnail_away() {
        return thumbnail_away;
    }

    public void setThumbnail_away(String thumbnail_away) {
        this.thumbnail_away = thumbnail_away;
    }

    private String thumbnail_home;
    private String thumbnail_away;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompetition_type() {
        return competition_type;
    }

    public void setCompetition_type(String competition_type) {
        this.competition_type = competition_type;
    }

    public int getCompetition_id() {
        return competition_id;
    }

    public void setCompetition_id(int competition_id) {
        this.competition_id = competition_id;
    }

    public int getHome_team() {
        return home_team;
    }

    public void setHome_team(int home_team) {
        this.home_team = home_team;
    }

    public int getAway_team() {
        return away_team;
    }

    public void setAway_team(int away_team) {
        this.away_team = away_team;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Double getWinning_odds_home() {
        return winning_odds_home;
    }

    public void setWinning_odds_home(Double winning_odds_home) {
        this.winning_odds_home = winning_odds_home;
    }

    public Double getWinning_odds_away() {
        return winning_odds_away;
    }

    public void setWinning_odds_away(Double winning_odds_away) {
        this.winning_odds_away = winning_odds_away;
    }

    public String getMatch_status() {
        return match_status;
    }

    public void setMatch_status(String match_status) {
        this.match_status = match_status;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
