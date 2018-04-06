package com.example.pavoo.sparkair;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class AdapterZaNijeBitno extends BaseAdapter {
    public List<FlightList> flightList;
    public List<userflight> flightsList;
    public Context context;
    int id=-1;

    public AdapterZaNijeBitno(Context c, int id){
        context = c;
        flightList = new ArrayList();
        flightsList = new ArrayList();
        this.id = id;
        List<userflight> allFlightss = userflight.listAll(userflight.class);
        Log.i("allflights", "pokrenuto");
        for(int i = 0;i<allFlightss.size();i++) {
            Log.i("allflights", "listitem"+i);
            long a = allFlightss.get(i).getUser().getId();
            flights b = allFlightss.get(i).getFlight();
            if(a==id){
                flightList.add(new FlightList(b.name));
                flightsList.add(allFlightss.get(i));
            }
        }
    }

    @Override
    public int getCount() {
        return flightList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.flight_list, viewGroup, false);
        Log.i("Doesthisevenshow","It does");
        final TextView user = row.findViewById(R.id.tvSubject);
        Button isMarked = row.findViewById(R.id.cbIsMarked);

        final FlightList temp = flightList.get(position);

        user.setText(temp.flight);

        isMarked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id==-1){
                    Intent j = new Intent(context,LoginActivity.class);
                    context.startActivity(j);
                }else {
                    Intent j = new Intent(context, usernakonlogina.class);
                    usersugar user = usersugar.findById(usersugar.class, id);
                    flights flight = flights.findById(flights.class, position+1);
                    userflight uf = new userflight(user, flight);
                    j.putExtra("id", id);
                }
            }
        });
        return row;
    }

    public boolean search(){
        return true;
    }

    public userflight getSUser(int i) {
        return flightsList.get(i);
    }

    public List<FlightList> getFlightList(){
        return flightList;
    }

    public void setFlightList(List<FlightList> flightList){
        this.flightList = flightList;
    }
}
