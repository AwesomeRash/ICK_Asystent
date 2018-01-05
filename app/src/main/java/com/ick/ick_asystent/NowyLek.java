package com.ick.ick_asystent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class NowyLek extends AppCompatActivity {

    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowy_lek);

    }

    protected void onStart(){
        super.onStart();
        myDB = new DBHelper(getApplicationContext());
    }

    public void onClick_newDrug(View view){

        TextView text1 = findViewById(R.id.nazwaLeku);
        TextView text2 = findViewById(R.id.doKiedyLek);
        Spinner spinner = findViewById(R.id.typSpinner);
        TextView text3 = findViewById(R.id.terminLeku1);
        TextView text4 = findViewById(R.id.terminLeku2);
        TextView text5 = findViewById(R.id.terminLeku3);

        // TODO: Dodanie alarmów przy dodawaniu leku

        myDB.createLek(text1.getText().toString(),
                spinner.getSelectedItemPosition(),
                text2.getText().toString(),
                text3.getText().toString()+" "+text4.getText().toString()+" "+text5.getText().toString()
                );

        startActivity(new Intent(this, Leki.class));
    }
}
