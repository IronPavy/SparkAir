package com.example.pavoo.sparkair;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class setFlights extends AppCompatActivity {

    public Context context;
    public setFlights(Context context) {
        this.context = context;
    }

    public void makeFlights(){
        flights flight;
        flight = new flights("Beograd41", "13:00", "13:00", "Mostar", "Beograd","" , 1, 300);
        flight.save();
        flight = new flights("Beograd42", "14:00", "15:00", "Mostar", "Beograd","", 3, 350);
        flight.save();
        flight = new flights("Beograd43", "15:00", "16:00", "Mostar", "Beograd","", 3, 425);
        flight.save();
    }
}
