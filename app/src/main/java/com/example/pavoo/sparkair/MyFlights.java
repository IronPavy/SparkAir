package com.example.pavoo.sparkair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;

public class MyFlights extends AppCompatActivity {

    public usersugar user;
    public flights flight;
    public List<userflight> list;
    public int id, id2;
    private ListAdapter myAdapter2;
    private ArrayAdapter<userflight> myAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_flights);


        Bundle s = getIntent().getExtras();
        id = s.getInt("id");
        id2 = s.getInt("id");
        List<userflight> allUserFlights = userflight.listAll(userflight.class);
        user = usersugar.findById(usersugar.class,id);
        flight = flights.findById(flights.class,id2);
        if(allUserFlights.isEmpty()){
            Toast.makeText(MyFlights.this, "No data.", Toast.LENGTH_SHORT).show();
        }else{

            for(int i = 0;i<allUserFlights.size();i++) {

                usersugar a = allUserFlights.get(i).getUser();
                flights b = allUserFlights.get(i).getFlight();

                if (a.equals(user) && (b.equals(flight))) {
                    list.add(allUserFlights.get(i));
                }
            }
        }

        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        for(int i = 0; i < list.size(); i++){
            myAdapter.add(list.get(i));
        }

        listView = findViewById(R.id._listViewvv);


        listView.setAdapter(myAdapter);

        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = listView.getItemAtPosition(position).toString();
                Intent i = new Intent(MyFlights.this, ItemClicked.class);
                i.putExtra("id",value);
                Log.i("itemClicked", "clicked"+value);
                startActivity(i);
            }
        });

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.delete:
                myAdapter.remove(myAdapter.getItem(info.position));
                myAdapter.notifyDataSetChanged();
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
