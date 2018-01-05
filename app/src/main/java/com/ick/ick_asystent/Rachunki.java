package com.ick.ick_asystent;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class Rachunki extends AppCompatActivity {

   // String[] nameArray= {"Prąd", "Gaz"};

    String[] infoArray= {"120.00", "140.00", "260.00"};

    String[] dateArray = {"15.12.2017", "24.12.2017", "3.02.2018"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rachunki);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }
    @Override
    protected void onStart(){
        super.onStart();
        DBHelper myDB = new DBHelper(getApplicationContext());

        //RachunekListAdapter rachAdp = new RachunekListAdapter(this, nameArray, infoArray, dateArray);
        ArrayList<RachunekDBModel> rachunki = myDB.getAllRachunek();
        String[] nameArray = new String[rachunki.size()];
        RachunekListAdapter rachAdp = new RachunekListAdapter(this, rachunki, nameArray);
        listView = findViewById(R.id.rachunkiListView);
        listView.setAdapter(rachAdp);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Main.class);
        startActivityForResult(myIntent, 0);
        return true;
    }


    public void onClick_nowy(View v){
        startActivity(new Intent(this, NowyRachunek.class));
    }

    public void onClick_szacunek(View v){
        startActivity(new Intent(this, SzacRachunki.class));
    }
}
