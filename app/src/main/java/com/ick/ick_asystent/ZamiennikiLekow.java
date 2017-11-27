package com.ick.ick_asystent;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

public class ZamiennikiLekow extends AppCompatActivity {


    String[] nameArray= {"Auronix", "Moklar", "Mobemiol"};

    String[] infoArray= {"30 szt", "30 szt", "30 szt"};

    String[] cenaArray = {"22.59", "5.19", "5.76"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zamienniki_lekow);

        ZamiennikiListAdapter rachAdp = new ZamiennikiListAdapter(this, nameArray, infoArray, cenaArray);
        listView = findViewById(R.id.zamiennikiList);
        listView.setAdapter(rachAdp);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Leki.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}
