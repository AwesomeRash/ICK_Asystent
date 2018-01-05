package com.ick.ick_asystent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class NowyRachunek extends AppCompatActivity {

    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowy_rachunek);

        myDB = new DBHelper(getApplicationContext());

    }


    public void onClick_newBill(View view){

        TextView text1 = findViewById(R.id.nazwaRachunku);
        TextView text2 = findViewById(R.id.dataOplacenia);
        Spinner spinner = findViewById(R.id.czestoscSpinner);
        TextView text4 = findViewById(R.id.kwota1);
        TextView text5 = findViewById(R.id.kwota2);
        TextView text6 = findViewById(R.id.kwota3);

        myDB.createRachunek(text1.getText().toString(),
                            text2.getText().toString(),
                            spinner.getSelectedItemPosition(),
                            Integer.parseInt(text4.getText().toString()),
                            Integer.parseInt(text5.getText().toString()),
                            Integer.parseInt(text6.getText().toString())

        );

        startActivity(new Intent(this, Rachunki.class));
    }
}
