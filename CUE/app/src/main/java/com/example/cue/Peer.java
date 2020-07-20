package com.example.cue;

import android.graphics.drawable.Drawable;

public class Peer {

    private Drawable img, cit;
    private String details, name;
    private double rating;

    public Peer(Drawable img, Drawable cit, String details, String name, double rating){
        this.details=details;
        this.img = img;
        this.cit = cit;
        this.name = name;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getCit() {
        return cit;
    }

    public void setCit(Drawable cit) {
        this.cit = cit;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public Drawable getImg() {
        return img;
    }
}
