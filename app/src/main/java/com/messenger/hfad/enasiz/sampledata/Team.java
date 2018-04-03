package com.messenger.hfad.enasiz.sampledata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nahom on 2018-04-01.
 */

public class Team {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("team_name")
    @Expose
    private String team_name;

    @SerializedName("team_thumbnail")
    @Expose
    private String team_thumbnail;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_thumbnail() {
        return team_thumbnail;
    }

    public void setTeam_thumbnail(String team_thumbnail) {
        this.team_thumbnail = team_thumbnail;
    }
}
