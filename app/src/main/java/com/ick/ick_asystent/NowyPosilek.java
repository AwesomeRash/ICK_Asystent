package com.ick.ick_asystent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by Roderick on 06.01.2018.
 */

public class NowyPosilek extends AppCompatActivity {


    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowy_posilek);
    }

    protected void onStart(){
        super.onStart();
        myDB = new DBHelper(getApplicationContext());
    }

    public void onClick_newMeal(View view){

        EditText nazwaField = findViewById(R.id.nazwaPosilku);
        Spinner typSpinner = findViewById(R.id.posilekSpinner);
        EditText kiedyField = findViewById(R.id.terminPosilku);


        Pattern p = Pattern.compile("^((?:[01]\\d|2[0-3]):[0-5]\\d)");

        if (!kiedyField.getText().toString().equals("") && !nazwaField.getText().toString().equals("")) {
            if(p.matcher(kiedyField.getText().toString()).matches()) {
                myDB.createPosilek(
                        nazwaField.getText().toString(),
                        typSpinner.getSelectedItemPosition(),
                        kiedyField.getText().toString()
                );
                startActivity(new Intent(this, Jedzenie.class));
            }
            else
                Toast.makeText(getApplicationContext(), "Niepoprawny format godziny", Toast.LENGTH_SHORT).show();
        } else
        Toast.makeText(getBaseContext(), "Podaj proszę wymagane informacje.", Toast.LENGTH_LONG).show();
    }
}

