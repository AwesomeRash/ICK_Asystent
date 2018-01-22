package com.ick.ick_asystent;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Przypomnienia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przypomnienia);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Main.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

    public void onClick_myPrzypomnienia(View view){
        startActivity(new Intent(this, PrzypomnienieDisplay.class));
    }

    public void onClick_nowePrzypomnienie(View view){
        startActivity(new Intent(this, NowePrzypomnienie.class));
    }

    public void onClick_confPrzypomnienia(View view){
        startActivity(new Intent(this, PrzypomnieniaKonf.class));
    }


    public void onBackPressed(){
        Intent intent = new Intent(this, Main.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
