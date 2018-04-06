package com.example.pavoo.sparkair;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.orm.SugarContext;

public class usernakonlogina extends AppCompatActivity {

    TextView tvnakonlogina1, tvnakonlogina2, tvnakonlogina3;
    public String username, avatarurl;
    public int id;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SugarContext.init(this);
        setContentView(R.layout.activity_usernakonlogina);

        tvnakonlogina1 = findViewById(R.id.tvnakonlogina1);
        tvnakonlogina2 = findViewById(R.id.tvnakonlogina2);
        tvnakonlogina3 = findViewById(R.id.tvNakonLogina3);
        button3 = findViewById(R.id.button3);

/** Iz bundlea uzme username, i u showdata provjeri username i pokupi ostale podatke da ih moze koristiti*/
        Bundle s = getIntent().getExtras();

        id = s.getInt("id");
        showData(id);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(usernakonlogina.this, CitanjeKorisnickihLetova.class);
                i.putExtra("id", id);
                startActivity(i);
            }
        });
    }

    public void showData(final int id){

        usersugar user = usersugar.findById(usersugar.class, id);

        tvnakonlogina1.setText("EMAIL: " + user.getLogin());
        tvnakonlogina2.setText("Ime: " + user.getFirstname() + " " + user.getLastname());

        /*
        Glide.with(this)
                .load(avatarurl)
                .into(avatar);
        avatarurl = user.getAvatar();
        */

        if(user.getAdmin()==1) { //Gornje za admina, donje za korisnika, to je to u biti

            tvnakonlogina3.setText("Admin");
            FloatingActionButton fab = findViewById(R.id.actionButton);
            fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(usernakonlogina.this, DodavanjeLetova.class);
                startActivity(i);
                }
             });

        }else{
            tvnakonlogina3.setText("Obican korisnik");
            FloatingActionButton fab = findViewById(R.id.actionButton);
            fab.setVisibility(View.INVISIBLE);
        }
    }
}
