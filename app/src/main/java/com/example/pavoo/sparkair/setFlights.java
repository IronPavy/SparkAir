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

    public void makeFlights(){ //najjednostavnije sto mi je sad palo na pamet :P, samo pokrenuo jednom u login, ako ce se
        // dodavati jos letova MORAT ce se promjeniti keyword u sharedpreferences(trenutno u login.class), npr letovi1 - > letovi 2
        // moze se ovo dodati i u loginactivity.java pod sharedpreferences da ne otvara ovu klasu ali
        // kontam preglednije je ovako dodavati letove

        flights flight;
        flight = new flights("Beograd41", "13:00", "13:00", "Mostar", "Beograd", 1, 300);
        flight.save();
        flight = new flights("Beograd42", "14:00", "15:00", "Mostar", "Beograd", 1, 350);
        flight.save();
        flight = new flights("Beograd43", "15:00", "16:00", "Mostar", "Beograd", 1, 425);
        flight.save();
    }
}
