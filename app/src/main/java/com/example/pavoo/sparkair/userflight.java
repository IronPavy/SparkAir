package com.example.pavoo.sparkair;

import com.orm.SugarRecord;

public class userflight extends SugarRecord {
    public usersugar user;
    public flights flight;

    public userflight() {
    }

    public userflight(usersugar user, flights flight) {
        this.user = user;
        this.flight = flight;
    }

    public usersugar getUser() {
        return user;
    }

    public void setUser(usersugar user) {
        this.user = user;
    }

    public flights getFlight() {
        return flight;
    }

    public void setFlight(flights flight) {
        this.flight = flight;
    }
}
