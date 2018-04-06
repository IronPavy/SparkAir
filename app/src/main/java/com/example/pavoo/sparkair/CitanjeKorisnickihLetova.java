package com.example.pavoo.sparkair;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class CitanjeKorisnickihLetova extends AppCompatActivity {

    ListView lvNijeBitno;
    public AdapterZaNijeBitno flightListAdapter;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citanje_korisnickih_letova);

        Bundle s = getIntent().getExtras();
        id = s.getInt("id");

        flightListAdapter = new AdapterZaNijeBitno(getApplicationContext(), id);


        lvNijeBitno = findViewById(R.id.lvNijeBitno);
        lvNijeBitno.setAdapter(flightListAdapter);


    }
}
