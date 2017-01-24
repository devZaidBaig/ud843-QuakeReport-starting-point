package com.example.android.quakereport;

/**
 * Created by Zaid on 1/13/2017.
 */

public class Data {
    private double  Magnitude;
    private String Place,Url;
    private long Date;

    public Data(double magnitude,String place,long date,String url){
        Magnitude = magnitude;
        Date = date;
        Place = place;
        Url = url;
    }

    public double getMag(){
        return Magnitude;
    }

    public Long getDate(){
        return Date;
    }

    public String getPlace(){
        return Place;
    }

    public String getUrl(){return Url;}
}
