package com.ick.ick_asystent;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;


public class Leki extends AppCompatActivity {


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leki);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onStart(){
        super.onStart();
        DBHelper myDB = new DBHelper(getApplicationContext());


        ArrayList<LekDBModel> leki = myDB.getAllLek();
        String[] nameArray = new String[leki.size()];

        LekListAdapter lekAdapter = new LekListAdapter(this, leki, nameArray);
        listView = findViewById(R.id.lekiListView);
        listView.setAdapter(lekAdapter);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Main.class);
        startActivityForResult(myIntent, 0);
        return true;

    }

    public void onClick_nowyLek(View v){
        startActivity(new Intent(this, NowyLek.class));
    }

    public void onClick_zamienniki(View v){
        startActivity(new Intent(this, ZamiennikiLekow.class));
    }

}


