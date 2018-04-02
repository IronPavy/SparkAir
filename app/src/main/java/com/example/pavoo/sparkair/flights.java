package com.example.pavoo.sparkair;


import com.orm.SugarRecord;

import java.util.List;

public class flights extends SugarRecord {
    String name;
    String time1;
    String time2;
    String place1;
    String place2;
    int spots;
    float price;

    public flights(){

    }

    public flights(String name, String time1, String time2, String place1, String place2, int spots, float price) {
        this.name = name;
        this.time1 = time1;
        this.time2 = time2;
        this.place1 = place1;
        this.place2 = place2;
        this.spots = spots;
        this.price = price;
    }

    public List<userflight> getUserFlights(){
        return userflight.find(userflight.class, "flight = ?", String.valueOf(this.getId()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getPlace1() {
        return place1;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public String getPlace2() {
        return place2;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    public int getSpots() {
        return spots;
    }

    public void setSpots(int spots) {
        this.spots = spots;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
