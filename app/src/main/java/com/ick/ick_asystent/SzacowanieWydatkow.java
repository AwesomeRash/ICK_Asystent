package com.ick.ick_asystent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//TODO: Szacowanie na podstawie terminów kolejnych rachunków.
//Zmiana automatycznie przy wybraniu opcji na dropdownie
//Każdy rachunek i suma w osobnej linijce
// Główna suma osobno.

public class SzacowanieWydatkow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szacowanie_wydatkow);
    }
}
