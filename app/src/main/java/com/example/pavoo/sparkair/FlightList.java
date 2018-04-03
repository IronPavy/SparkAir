package com.example.pavoo.sparkair;

/**
 * Created by Edo on 16.6.2017..
 */

public class FlightList {
    public String flight;
    public boolean isMarked;

    FlightList(String flight){
        this.flight = flight;
        this.isMarked = false;
    }

    public String getUser() {
        return flight;
    }

    public void setUser(String user) {
        this.flight = user;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }
}
