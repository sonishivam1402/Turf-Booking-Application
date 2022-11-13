package com.example.turfbookingapp;

public class TurfModel {
    private int turf_img;
    private String turf_name, turf_area, turf_price;
    private float turf_rating;

    TurfModel(String turf_name, String turf_area, int turf_img, float turf_rating, String turf_price) {
        this.turf_name = turf_name;
        this.turf_area = turf_area;
        this.turf_img = turf_img;
        this.turf_rating = turf_rating;
        this.turf_price = turf_price;
    }

    public int getTurf_img() { return turf_img;}

    public void setTurf_img(int turf_img) {
        this.turf_img = turf_img;
    }

    public String getTurf_name() {
        return turf_name;
    }

    public void setTurf_name(String turf_name) {
        this.turf_name = turf_name;
    }

    public String getTurf_area() {
        return turf_area;
    }

    public void setTurf_area(String turf_area) {
        this.turf_area = turf_area;
    }

    public String getTurf_price() {
        return turf_price;
    }

    public void setTurf_price(String turf_area) {
        this.turf_price = turf_price;
    }

    public float getTurf_rating() { return this.turf_rating;}

    public void setTurf_rating(float turf_rating) {
        this.turf_rating = turf_rating;
    }

}
