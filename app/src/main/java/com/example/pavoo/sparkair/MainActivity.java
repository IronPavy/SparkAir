package com.example.pavoo.sparkair;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.orm.SugarContext;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button reserveButton;
    public FlightListAdapter flightListAdapter;
    public FlightListAdapter flightListAdapter2;
    NavigationView navigationView;
    ListView maLV;
    int id=-1;
    public GetUsersFromJSON g;
    public setFlights sf;
    SharedPreferences loginPreferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SugarContext.init(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        reserveButton = findViewById(R.id.reservedButton);

        g = new GetUsersFromJSON(this);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String store = preferences.getString("stored", "");
        if(store.equalsIgnoreCase(""))
        {
            g.getData();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("stored","Data is stored");
            editor.commit();
        }
        sf = new setFlights(this);
        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        String store2 = preferences.getString("letovi1", "");
        if(store2.equalsIgnoreCase(""))
        {
            sf.makeFlights();
            SharedPreferences.Editor editor = preferences2.edit();
            editor.putString("letovi1", "Data is stored");
            editor.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View hView =  navigationView.getHeaderView(0);
        TextView nav_user =hView.findViewById(R.id.textViewNav2);
        // do the same for other MenuItems
        // add NavigationItemSelectedListener to check the navigation clicks
        navigationView.setNavigationItemSelectedListener(this);

        createLayout();
    }
    @Override
    protected void onResume() {
        super.onResume();
        createLayout();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createLayout();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        createLayout();
    }

    public void createLayout(){
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null) {
            if(bundle.containsKey("id")) {
                id = bundle.getInt("id");
                Log.i("MainActivity Log", "id:"+String.valueOf(id));
                flightListAdapter = new FlightListAdapter(getApplicationContext(), id);
                usersugar user = usersugar.findById(usersugar.class, id);
                NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
                navigationView.setNavigationItemSelectedListener(this);
                View hView =  navigationView.getHeaderView(0);
                TextView nav_user =hView.findViewById(R.id.textViewNav2);
                TextView nav_user2 =hView.findViewById(R.id.textViewNav1);
                nav_user.setText(user.getLogin());
                nav_user2.setText(user.getFirstname() + " " + user.getLastname());
                // do the same for other Men

                maLV = findViewById(R.id.maLV);
                maLV.setAdapter(flightListAdapter);

                hideItem(0);
            }
        } else {
            Log.i("MainActivity Log", "id is null");
            flightListAdapter2 = new FlightListAdapter(getApplicationContext());
            hideItem(1);
            maLV = findViewById(R.id.maLV);
            maLV.setAdapter(flightListAdapter2);
        }
    }
    private void hideItem(int id)
    {
        navigationView = findViewById(R.id.nav_view);
        Menu nav_Menu = navigationView.getMenu();
        if(id==0) {
            nav_Menu.findItem(R.id.nav_login).setVisible(false);
        }else{
            nav_Menu.findItem(R.id.nav_logout).setVisible(false);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_logout) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
