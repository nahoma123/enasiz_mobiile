package com.messenger.hfad.enasiz.sampledata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nahom on 2018-04-01.
 */

public class Competition {

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("nation")
    @Expose
    public String nation;

    @SerializedName("league_name")
    @Expose
    public String league_name;

    @SerializedName("start_time")
    @Expose
    public String start_time;

    @SerializedName("end_time")
    @Expose
    public String end_time;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("number_of_teams")
    @Expose
    public int number_of_teams;

    @SerializedName("fifa_ranking")
    @Expose
    public double fifa_ranking;

    @SerializedName("matches_played")
    @Expose
    public int matches_played;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * For Cups
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber_of_teams() {
        return number_of_teams;
    }

    public void setNumber_of_teams(int number_of_teams) {
        this.number_of_teams = number_of_teams;
    }

    public double getFifa_ranking() {
        return fifa_ranking;
    }

    public void setFifa_ranking(double fifa_ranking) {
        this.fifa_ranking = fifa_ranking;
    }

    public int getMatches_played() {
        return matches_played;
    }

    public void setMatches_played(int matches_played) {
        this.matches_played = matches_played;
    }


}
