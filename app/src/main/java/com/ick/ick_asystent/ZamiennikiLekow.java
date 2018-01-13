package com.ick.ick_asystent;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ZamiennikiLekow extends AppCompatActivity {


    //String[] nameArray= {"Auronix", "Moklar", "Mobemiol"};

    //String[] infoArray= {"30 szt", "30 szt", "30 szt"};

    //String[] cenaArray = {"22.59", "5.19", "5.76"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zamienniki_lekow);
    }

    @Override
    protected void onStart(){
        super.onStart();

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Leki.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

    public void onClick_search(View v){
        EditText searchbar = findViewById(R.id.searchZamiennik);
        String nazwa = searchbar.getText().toString();

        if(!nazwa.equals("")){
            DBHelper myDB = new DBHelper(getApplicationContext());
            ArrayList<LekarstwoDBModel> lekarstwa = myDB.getAllZamienniki(nazwa);
            if(lekarstwa.size()==0){
                Toast.makeText(getApplicationContext(), "Nie znaleziono leku", Toast.LENGTH_SHORT).show();
            } else{
            String[] nameArray = new String[lekarstwa.size()];
            ZamiennikiListAdapter rachAdp = new ZamiennikiListAdapter(this, lekarstwa, nameArray);
            listView = findViewById(R.id.zamiennikiList);
            listView.setAdapter(rachAdp);
            myDB.close();
        }
        }

    }


}
