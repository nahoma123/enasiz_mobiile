package com.messenger.hfad.enasiz.sampledata;

import java.util.ArrayList;

/**
 * Created by Nahom on 2018-03-23.
 */
// Model for the incomming json data
public class Item {
    public String title,image;
    public int year;
    public double rate;
    private ArrayList<String> genre;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }
}
