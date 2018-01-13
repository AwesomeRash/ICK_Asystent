package com.ick.ick_asystent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

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

        final EditText termin1 = findViewById(R.id.terminLeku1);
        final EditText termin2 = findViewById(R.id.terminLeku2);
        termin2.setVisibility(View.INVISIBLE);
        final EditText termin3 = findViewById(R.id.terminLeku3);
        termin3.setVisibility(View.INVISIBLE);


        termin1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                termin2.setVisibility(View.VISIBLE);
            }
        });

        termin2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                termin3.setVisibility(View.VISIBLE);
            }
        });

    }

    public void onClick_newDrug(View view){

        TextView text1 = findViewById(R.id.nazwaLeku);
        TextView text2 = findViewById(R.id.doKiedyLek);
        Spinner spinner = findViewById(R.id.typSpinner);
        TextView text3 = findViewById(R.id.terminLeku1);
        TextView text4 = findViewById(R.id.terminLeku2);
        TextView text5 = findViewById(R.id.terminLeku3);

        Pattern p = Pattern.compile("^((?:[01]\\d|2[0-3]):[0-5]\\d)");
        if(text1.getText().length()==0 || text3.getText().length()==0)
        {
            Toast.makeText(getApplicationContext(), "Podaj potrzebne informacje", Toast.LENGTH_SHORT).show();
        }else if((!text5.getText().toString().equals("") && !p.matcher(text3.getText().toString()).matches()) ||(!text5.getText().toString().equals("") &&  !p.matcher(text4.getText().toString()).matches())|| (!text5.getText().toString().equals("") && !p.matcher(text5.getText().toString()).matches())){
            Toast.makeText(getApplicationContext(), "Niepoprawny format godziny", Toast.LENGTH_SHORT).show();
        }else{
        // TODO: Dodanie alarmów przy dodawaniu leku

        myDB.createLek(text1.getText().toString(),
                spinner.getSelectedItemPosition(),
                text2.getText().toString(),
                text3.getText().toString()+" "+text4.getText().toString()+" "+text5.getText().toString()
                );

        startActivity(new Intent(this, Leki.class));
    }}
}
