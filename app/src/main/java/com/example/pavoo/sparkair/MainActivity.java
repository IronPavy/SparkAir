package com.example.pavoo.sparkair;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.orm.SugarContext;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button reserveButton;
    public FlightListAdapter flightListAdapter;

    ListView maLV;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SugarContext.init(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        reserveButton = findViewById(R.id.reservedButton);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Pub/Sub"));
        tabLayout.addTab(tabLayout.newTab().setText("Presence"));
        tabLayout.addTab(tabLayout.newTab().setText("Multi"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        flightListAdapter = new FlightListAdapter(getApplicationContext());

        maLV = findViewById(R.id.maLV);
        maLV.setAdapter(flightListAdapter);

        //Ovo je proba za button, da ode na Login kad kliknes R(reserve
        //a trebalo bi provjerit jel korisnik logiran, ako nije onda nek ide, ako je onda da ostane tu i iskoci alertdialog
        //koji imas tu kod
/*
        reserveButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             AlertDialog.Builder builder;
             if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                 builder = new AlertDialog.Builder( MainActivity.this, android.R.style.Theme_Material_Dialog_Alert);
             } else {
                 builder = new AlertDialog.Builder(MainActivity.this);
             }
             builder.setTitle("Delete entry")
                     .setMessage("Are you sure you want to delete this entry?")
                     .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                         public void onClick(DialogInterface dialog, int which) {
                             reserveButton.setBackgroundColor(getApplication().getResources().getColor(R.color.colorPrimaryDark));
                             Toast.makeText(MainActivity.this, "Svaka cast", Toast.LENGTH_SHORT).show();
                         }
                     })
                     .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                         public void onClick(DialogInterface dialog, int which) {
                             // do nothing
                         }
                     })
                     .setIcon(android.R.drawable.ic_dialog_alert)
                     .show();



             Intent i = new Intent(MainActivity.this, LoginActivity.class);
             startActivity(i);
         }
        });

*/

        // builder.setMessage("Are you sure?")
        //   .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        //    @Override
        //    public void onClick(DialogInterface dialog, int which) {
        //    reserveButton.setBackgroundColor(getApplication().getResources().getColor(R.color.colorPrimaryDark));
        //  }
        //  }).setNegativeButton("No", new DialogInterface.OnClickListener() {
        //   @Override
        //  public void onClick(DialogInterface dialog, int which) {
        //   reserveButton.setBackgroundColor(getApplication().getResources().getColor(R.color.colorDarkerGray));
        //   }
        //  });
        // AlertDialog alert = builder.create();
        //  alert.show();
        //  }
        //  });



        //FLOATING BUTTON
        //FloatingActionButton fab = findViewById(R.id.reserveButton);
        //fab.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
            //    Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
           //             .setAction("Action", null).show();
          //  }
     // };


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_pocetna) {

        } else if (id == R.id.nav_futureFlights) {

        } else if (id == R.id.nav_exFlights) {

        } else if (id == R.id.nav_kontakt) {

        } else if (id == R.id.nav_login) {

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
