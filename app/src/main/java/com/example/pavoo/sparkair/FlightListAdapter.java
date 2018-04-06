package com.example.pavoo.sparkair;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class FlightListAdapter extends BaseAdapter {
    public List<FlightList> flightList;
    public List<flights> flightsList;
    public Context context;
    int id=-1;
    int pposition;
    long idflight;

    public FlightListAdapter(Context c, int id){
        context = c;
        flightList = new ArrayList();
        flightsList = new ArrayList();
        this.id = id;
        List<flights> allFlightss = flights.listAll(flights.class);
        Log.i("ADDINGFLIGHTSWITHID", "Added");
        for(int i = 0;i<allFlightss.size();i++) {
            String a = allFlightss.get(i).getName();
            float b = allFlightss.get(i).getPrice();
                Log.i("ADDINGFLIGHTS", "Added");
                flightList.add(new FlightList(a+"\nCijena:"+b+"KM"));
                flightsList.add(allFlightss.get(i));
        }
    }

    public FlightListAdapter(Context c){
        context = c;
        flightList = new ArrayList();
        flightsList = new ArrayList();
        List<flights> allFlights = flights.listAll(flights.class);


        for(int i = 0;i<allFlights.size();i++) {
            String a = allFlights.get(i).getName();
            float b = allFlights.get(i).getPrice();
            Log.i("ADDINGWITHOUTID", "Added");
            flightList.add(new FlightList(a+"\nCijena:"+b+"KM"));
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
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.flight_list, viewGroup, false);
        Log.i("Doesthisevenshow","It does");
        final TextView user = row.findViewById(R.id.tvSubject);
        final Button isMarked = row.findViewById(R.id.cbIsMarked);
        final Button isMarked2 = row.findViewById(R.id.cbIsMarked2);
        if(flightsList.get(position).getNotes().equals("")){
            isMarked2.setVisibility(View.INVISIBLE);
        }

        isMarked2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, StartingActivity.class);
                i.putExtra("id", position);
                i.putExtra("userid", id);
                context.startActivity(i);
            }
        });

        final FlightList temp = flightList.get(position);

        user.setText(temp.flight);

        boolean test = false;
        List<userflight> allFlightss = userflight.listAll(userflight.class);
        Log.i("allflights", "pokrenuto");
        final userflight uff;

        for(int i = 0;i<allFlightss.size();i++) {
            Log.i("allflights", "listitem"+i);
            long a = allFlightss.get(i).getUser().getId();
            flights b = allFlightss.get(i).getFlight();
            if(a==id){
                if(b.getId()==position+1) {
                    test = true;
                    idflight = allFlightss.get(i).getId();
                    isMarked.setBackgroundColor(Color.RED);
                }
            }
        }
            if(test==true){
                pposition = position;
                isMarked.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        isMarked.setBackgroundColor(Color.RED);
                        userflightDelete(idflight);
                        isMarked.setBackgroundColor(Color.RED);
                    }
                });

            }else {
                isMarked.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (id == -1) {
                            Intent j = new Intent(context, LoginActivity.class);
                            context.startActivity(j);
                        } else {
                            if(flights.findById(flights.class, position+1).getSpots()>=5){
                                Toast.makeText(context, "PREVISE KORISNIKA SE PRIJAVILO ZA OVAJ LET",Toast.LENGTH_SHORT).show();
                            }else {
                                Intent j = new Intent(context, usernakonlogina.class);
                                usersugar user = usersugar.findById(usersugar.class, id);
                                flights flight = flights.findById(flights.class, position + 1);
                                userflight uf = new userflight(user, flight);
                                uf.save();
                                flight.spots++;
                                flight.save();
                                j.putExtra("id", id);
                                isMarked.setBackgroundColor(Color.RED);
                                context.startActivity(j);
                            }
                        }
                    }
                });
            }
        return row;
    }

    public boolean search(){
        return true;
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

    public void userflightDelete(long ppposition){
        flights flight = userflight.findById(userflight.class, ppposition).getFlight();
        userflight.delete(userflight.findById(userflight.class, ppposition));
        flight.spots--;
        flight.save();
        Toast.makeText(context, "Izbrisan let!", Toast.LENGTH_SHORT).show();
        notifyDataSetChanged();
    }
}

