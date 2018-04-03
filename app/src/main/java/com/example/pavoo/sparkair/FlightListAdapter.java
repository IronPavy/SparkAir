package com.example.pavoo.sparkair;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Isao kao druga 2 adaptera za prikaz
 */

public class FlightListAdapter extends BaseAdapter {
    public List<String> list;
    public List<FlightList> flightList;
    public List<flights> flightsList;
    public Context context;

    public FlightListAdapter(Context c){
        context = c;
        flightList = new ArrayList<FlightList>();
        flightsList = new ArrayList<flights>();

        List<flights> allFlights = flights.listAll(flights.class);

        for(int i = 0;i<allFlights.size();i++) {
            String a = allFlights.get(i).getName();
            float b = allFlights.get(i).getPrice();

                flightList.add(new FlightList(a+b));
                flightsList.add(allFlights.get(i));

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
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.subject_list, viewGroup, false);

        TextView user = (TextView) row.findViewById(R.id.tvSubject);
        CheckBox isMarked = (CheckBox) row.findViewById(R.id.cbIsMarked);

        final FlightList temp = flightList.get(position);

        user.setText(temp.flight);
        isMarked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(temp.isMarked()){
                    temp.setMarked(false);
                }else {
                    temp.setMarked(true);
                }
            }
        });

        return row;
    }

    public flights getSUser(int i) {
        return flightsList.get(i);
    }

    public List<FlightList> getFlightList(){
        return flightList;
    }

    public void setFlightList(List<FlightList> flightList){
        this.flightList = flightList;
    }
}
