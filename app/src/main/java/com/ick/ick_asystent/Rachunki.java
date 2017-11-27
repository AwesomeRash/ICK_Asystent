package com.ick.ick_asystent;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class Rachunki extends AppCompatActivity {

    String[] nameArray= {"Prąd", "Gaz", "Woda"};

    String[] infoArray= {"120.00", "140.00", "260.00"};

    String[] dateArray = {"15.12.2017", "24.12.2017", "3.02.2018"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rachunki);

        RachunekListAdapter rachAdp = new RachunekListAdapter(this, nameArray, infoArray, dateArray);
        listView = findViewById(R.id.lekiListView);
        listView.setAdapter(rachAdp);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

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
