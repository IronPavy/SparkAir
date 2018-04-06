package com.example.pavoo.sparkair;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ItemClicked  extends AppCompatActivity{
    TextView tvItemClicked;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_clicked);
        tvItemClicked = findViewById(R.id.tvItemClicked);
        Bundle s = getIntent().getExtras();
        if(s!=null)
            tvItemClicked.setText(s.getString("id"));
    }
}