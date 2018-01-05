package com.ick.ick_asystent;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class Jedzenie extends AppCompatActivity {

    String[] nameArray = {"Sniadanie","Obiad","Kolacja"};

    String[] infoArray = {
            "6:30",
            "13:00",
            "17:00"
    };

    Integer[] imageArray = {R.drawable.sniadanie,
            R.drawable.ic_45471,
            R.drawable.sniadanie};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jedzenie);

        LekListAdapter whatever = new LekListAdapter(this, nameArray, infoArray, imageArray);
        listView = findViewById(R.id.rachunkiListView);
        listView.setAdapter(whatever);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Main.class);
        startActivityForResult(myIntent, 0);
        return true;
    }


    public void onClick_przepis(View v){
        startActivity(new Intent(this, Przepisy.class));
    }

    public void onClick_dieta(View v){
        startActivity(new Intent(this, Dieta.class));
    }

    public void onClick_modPosilek(View v){
        startActivity(new Intent(this, ModPosilek.class));
    }
}
