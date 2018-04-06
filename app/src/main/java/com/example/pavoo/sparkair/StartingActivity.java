package com.example.pavoo.sparkair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        TextView textView = findViewById(R.id.tvStarting);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null) {
                final int id = bundle.getInt("id");
                int userid = bundle.getInt("userid");
                final flights flight = flights.findById(flights.class, id+1);

            Button btnEdit = findViewById(R.id.btnEdit);
            final EditText etNotes = findViewById(R.id.etNotes);
            if(userid!=-1){
                if(usersugar.findById(usersugar.class, userid).getAdmin()==1) {
                    etNotes.setText(flight.notes);
                    btnEdit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            flight.notes = etNotes.getText().toString();
                            flight.save();
                        }
                    });
                }else{
                    btnEdit.setVisibility(View.INVISIBLE);
                    etNotes.setVisibility(View.INVISIBLE);
                }
            }else{
                        btnEdit.setVisibility(View.INVISIBLE);
                        etNotes.setVisibility(View.INVISIBLE);
                }

                textView.setText("Biljeske:\n "+ flight.notes + "\n\n " + flight.spots + "/5 mjesta zauzeto.");

        }else {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }
}
