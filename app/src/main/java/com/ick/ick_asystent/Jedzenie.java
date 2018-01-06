package com.ick.ick_asystent;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

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


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    protected void onStart(){
        super.onStart();

        DBHelper myDB = new DBHelper(getApplicationContext());
        ArrayList<PosilekDBModel> posilki = myDB.getAllPosilek();
        String[] nameArray = new String[posilki.size()];
        PosilekListAdapter listAdapter = new PosilekListAdapter(this, posilki, nameArray);
        listView = findViewById(R.id.rachunkiListView);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String item = adapterView.getItemAtPosition(i).toString();
                System.out.println("OH HEJ, DOTARLES DO "+item);
                Bundle b = new Bundle();
                b.putString("posilek", item);

                Intent intent = new Intent(view.getContext(), ModPosilek.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
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

    public void onClick_nowyPosilek(View v){
        startActivity(new Intent(this, NowyPosilek.class));
    }
}
