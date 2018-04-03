package com.messenger.hfad.enasiz.sampledata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nahom on 2018-04-01.
 */

class Bet {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("minimum_wage")
    @Expose
    private int minimum_wage;

    @SerializedName("winning_odds_home")
    @Expose
    private double winning_odds_home;

    @SerializedName("winning_odds_away")
    @Expose
    private double winning_odds_away;

    @SerializedName("type_of_bet")
    @Expose
    private String type_of_bet;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("bet_created_at")
    @Expose
    private String bet_created_at;

    @SerializedName("match_id")
    @Expose
    private int match_id;

    @SerializedName("user_id")
    @Expose
    private int user_id;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    private int maximum_wage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinimum_wage() {
        return minimum_wage;
    }

    public void setMinimum_wage(int minimum_wage) {
        this.minimum_wage = minimum_wage;
    }

    public int getMaximum_wage() {
        return maximum_wage;
    }

    public void setMaximum_wage(int maximum_wage) {
        this.maximum_wage = maximum_wage;
    }

    public double getWinning_odds_home() {
        return winning_odds_home;
    }

    public void setWinning_odds_home(double winning_odds_home) {
        this.winning_odds_home = winning_odds_home;
    }

    public double getWinning_odds_away() {
        return winning_odds_away;
    }

    public void setWinning_odds_away(double winning_odds_away) {
        this.winning_odds_away = winning_odds_away;
    }

    public String getType_of_bet() {
        return type_of_bet;
    }

    public void setType_of_bet(String type_of_bet) {
        this.type_of_bet = type_of_bet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBet_created_at() {
        return bet_created_at;
    }

    public void setBet_created_at(String bet_created_at) {
        this.bet_created_at = bet_created_at;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }
}