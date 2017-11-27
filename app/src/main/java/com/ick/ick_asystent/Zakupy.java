package com.ick.ick_asystent;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Zakupy extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakupy);

        list=findViewById(R.id.listaZakupow);

        String zakupy[] = {"Cukier", "Banany", "Woda", "Mleko", "Masło", "Cukierki", "Wołowina", "Chleb"};

        ArrayList<String> zakupyList = new ArrayList<>();
        zakupyList.addAll(Arrays.asList(zakupy));

        adapter = new ArrayAdapter<String>(this, R.layout.zakupy_item, R.id.zakupyRow, zakupyList);

        adapter.notifyDataSetChanged();
        list.setAdapter(adapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Main.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

    public void onClick_addItem(View view){
        adapter.add("New");
        adapter.notifyDataSetChanged();
    }
}
