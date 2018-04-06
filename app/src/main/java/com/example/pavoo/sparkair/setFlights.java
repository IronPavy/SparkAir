package com.example.pavoo.sparkair;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

public class setFlights extends AppCompatActivity {

    public Context context;
    public setFlights(Context context) {
        this.context = context;
    }

    public void makeFlights(){
        flights flight;
        flight = new flights("Zagreb", "13:00", "14:00", "Mostar", "Zagreb","" , 1, 100);
        flight.save();
        flight = new flights("Budimpešta", "10:00", "15:00", "Mostar", "Budimpesta","Zbog losih vremenskih uvjeta let moze biti odgodjen!" , 1, 200);
        flight.save();
        flight = new flights("Atena", "08:00", "11:00", "Mostar", "Atena","" , 1, 300);
        flight.save();
        flight = new flights("London", "13:00", "13:00", "Mostar", "London","Zbog losih vremenenskih uvjeta let moze biti odgodjen!" , 1, 400);
        flight.save();
        flight = new flights("New York", "20:00", "03:00", "Mostar", "New York","" , 1, 1000);
        flight.save();
        flight = new flights("Sarajevo", "10:00", "10:30", "Mostar", "Sarajevo","" , 1, 50);
        flight.save();
        flight = new flights("Siroki Brijeg", "07:00", "07:05", "Mostar", "Siroki Brijeg","" , 1, 3000);
        flight.save();
        flight = new flights("Island", "15:00", "18:00", "Mostar", "Island","Zbog losih vremenskih uvjeta let moze biti odgodjen!" , 1, 400);
        flight.save();
    }
}
