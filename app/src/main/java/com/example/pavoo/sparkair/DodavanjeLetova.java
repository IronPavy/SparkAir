package com.example.pavoo.sparkair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DodavanjeLetova extends AppCompatActivity {

    EditText editText, editText2, editText3, editText4, editText5, editText6, editText7, editText8;
    Button button, button2;
    String name, time1, time2, place1, place2, notes;
    int spots;
    float price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodavanje_letova);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        editText6 = findViewById(R.id.editText6);
        editText7 = findViewById(R.id.editText7);
        editText8 = findViewById(R.id.editText8);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
                editText6.setText("");
                editText7.setText("");
                editText8.setText("");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString();
                place1 = editText2.getText().toString();
                place2 = editText3.getText().toString();
                time1 = editText4.getText().toString();
                time2 = editText5.getText().toString();
                spots = Integer.parseInt(editText6.getText().toString());
                price = Float.parseFloat(editText7.getText().toString());
                notes = editText8.toString();

                flights flight = new flights(name, time1, time2, place1, place2,notes , spots, price);
                flight.save();

                Toast.makeText(DodavanjeLetova.this, "Uspješno ste se dodali let!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
