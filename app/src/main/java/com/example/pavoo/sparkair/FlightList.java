package com.example.pavoo.sparkair;

import android.widget.Button;

public class FlightList {
    public String flight;
    public Button btn;

    FlightList(String flight){
        this.flight = flight;
    }

    public String getUser() {
        return flight;
    }

    public void setUser(String user) {
        this.flight = user;
    }
}
