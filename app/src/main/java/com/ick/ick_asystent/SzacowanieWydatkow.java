package com.ick.ick_asystent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

//TODO: Szacowanie na podstawie terminów kolejnych rachunków.
//Zmiana automatycznie przy wybraniu opcji na dropdownie
//Każdy rachunek i suma w osobnej linijce
// Główna suma osobno.

public class SzacowanieWydatkow extends AppCompatActivity {

    DBHelper myDB;
    ListView listView;
    float suma[] = {0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szacowanie_wydatkow);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myDB = new DBHelper(getApplicationContext());

        ArrayList<RachunekDBModel> rachunki = myDB.getAllRachunek();
        final TextView srednia = findViewById(R.id.textKwotaSzac);
        Spinner spinner = findViewById(R.id.szacowanieSpinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                srednia.setText(Float.toString(suma[position]));
                updateList(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });
        for (RachunekDBModel rachunek : rachunki) {
            for (int i=0; i <= 3; i++) {
                if (rachunek.jakCzesto == i) {
                    suma[i] += (rachunek.rachunek1 + rachunek.rachunek2 + rachunek.rachunek3) / 3;
                }
            }
            suma[4] = suma[3] * 2;
        }

    }

    public void updateList(int id){
        listView = findViewById(R.id.rachunkiListView);
        ArrayList<RachunekDBModel> rachunki = myDB.getAllRachunek();
        ArrayList<RachunekDBModel> rachunkicpy = new ArrayList<RachunekDBModel>();
        for (RachunekDBModel rach : rachunki) {
            if (rach.jakCzesto == id) rachunkicpy.add(rach);
        }
        String[] nameArray = new String[rachunkicpy.size()];
        RachunekListAdapter rachAdp = new RachunekListAdapter(this, rachunkicpy, nameArray);
        listView.setAdapter(rachAdp);
    }
}
