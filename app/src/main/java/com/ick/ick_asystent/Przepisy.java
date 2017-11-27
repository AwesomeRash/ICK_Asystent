package com.ick.ick_asystent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Przepisy extends AppCompatActivity {


    String[] nameArray = {"Przepis 1", "Przepis 2", "Przepis 3", "Przepis 4"};

    String[] trudArray = {"Latwy", "Trudny", "Trudny", "Sredni"};

    String[] czasArray = {"15 min", "45 min", "40 min", "1h 40min"};

    Integer[] imageArray = {
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
    };


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przepisy);


        PrzepisListAdapter przeAdp = new PrzepisListAdapter(this, nameArray, trudArray, czasArray, imageArray);
        listView = findViewById(R.id.przepisyList);
        listView.setAdapter(przeAdp);
    }
}
