package com.ick.ick_asystent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_Leki(View view){
        startActivity(new Intent(this, Leki.class));
        }

    public void onClick_Zakupy(View view){
        startActivity(new Intent(this, Zakupy.class));
    }

    public void onClick_Rachunki(View view){
        startActivity(new Intent(this, Rachunki.class));
    }

    public void onClick_Jedzenie(View view){
        startActivity(new Intent(this, Jedzenie.class));
    }

    public void onClick_Przypomnienie(View view){
        startActivity(new Intent(this, Przypomnienia.class));
    }
    public void onClick_Profil(View view){
        startActivity(new Intent (this, Profil.class));
    }

}
