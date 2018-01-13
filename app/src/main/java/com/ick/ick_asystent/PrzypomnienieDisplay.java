package com.ick.ick_asystent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class PrzypomnienieDisplay extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przypomnienie_display);
    }

    @Override
    protected void onStart(){
        super.onStart();
        DBHelper myDB = new DBHelper(getApplicationContext());

        ArrayList<PowiadomienieDBModel> powiadomienia = myDB.getAllPowiadomienie();
        String[] nameArray = new String[powiadomienia.size()];
        System.out.println("ROZMIAR POWIADOMIEN: "+powiadomienia.size());

        PowiadomienieListAdapter powiadomienieAdapter = new PowiadomienieListAdapter(this, powiadomienia,nameArray);
        listView = findViewById(R.id.powiadomieniaListView);
        listView.setAdapter(powiadomienieAdapter);
    }




}
