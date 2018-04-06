package com.example.pavoo.sparkair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StartingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        TextView textView = findViewById(R.id.tvStarting);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null) {
                int id = bundle.getInt("id");
                textView.setText("Biljeske:\n "+ flights.findById(flights.class, id+1).notes + "\n\n ");

        }else {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }
}
