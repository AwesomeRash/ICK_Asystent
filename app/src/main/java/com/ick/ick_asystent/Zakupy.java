package com.ick.ick_asystent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Zakupy extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> adapter;
    private EditText coKupic;
    private ArrayList<String> obecnaLista = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    public void onStart(){
        super.onStart();

        SharedPreferences sp = this.getSharedPreferences("com.ick.ick_asystent", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        setContentView(R.layout.activity_zakupy);
        coKupic = findViewById(R.id.editText2);
        list=findViewById(R.id.listaZakupow);


        if (!sp.getBoolean("zakupyEdytowane", false)){
            String zakupy[] = {"Cukier", "Banany", "Woda", "Mleko", "Masło", "Cukierki", "Wołowina", "Chleb"};

            ArrayList<String> zakupyList = new ArrayList<>();
            zakupyList.addAll(Arrays.asList(zakupy));

            obecnaLista = zakupyList;
            editor.putBoolean("zakupyEdytowane", true);
            editor.commit();
        }
        else {
            ArrayList<String> zakupyList = new ArrayList<>();
            Set<String> set = sp.getStringSet("zakupy", null);
            zakupyList.addAll(set);
            obecnaLista = zakupyList;
        }

        adapter = new ArrayAdapter<String>(this, R.layout.zakupy_item, R.id.zakupyRow, obecnaLista);

        adapter.notifyDataSetChanged();
        list.setAdapter(adapter);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Main.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

    public void onClick_addItem(View view){
        String itemTxt= coKupic.getText().toString();
        if(!itemTxt.matches("")) {
            obecnaLista.add(itemTxt);
            coKupic.setText("");
            _refresh();
        }
    }

    private void _refresh(){
        adapter = new ArrayAdapter<String>(this, R.layout.zakupy_item, R.id.zakupyRow, obecnaLista);
        adapter.notifyDataSetChanged();
        list.setAdapter(adapter);

        SharedPreferences sp = this.getSharedPreferences("com.ick.ick_asystent", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        Set<String> set = new HashSet<String>();
        set.addAll(obecnaLista);
        editor.putStringSet("zakupy", set);
        editor.commit();
    }

    public void onClick_removeItem(View view){
        TextView text = findViewById(R.id.zakupyRow);
        String przedmiot = text.getText().toString();
        obecnaLista.remove(obecnaLista.indexOf(przedmiot));

        _refresh();
    }
}
