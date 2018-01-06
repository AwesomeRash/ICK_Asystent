package com.ick.ick_asystent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

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

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onStart(){
        super.onStart();
        DBHelper myDB = new DBHelper(getApplicationContext());

        ArrayList<PrzepisDBModel> przepisy = myDB.getAllPrzepis();
        String[] nameArray = new String[przepisy.size()];

        PrzepisListAdapter przeAdp = new PrzepisListAdapter(this, przepisy,nameArray);
        listView = findViewById(R.id.przepisyList);
        listView.setAdapter(przeAdp);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();

                Bundle b = new Bundle();
                b.putString("przepis_name", item); //TODO: Przekazać poprawne ID

                Intent intent = new Intent(view.getContext(), przepisView.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        myDB.close();

    }

}
