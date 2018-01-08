package com.ick.ick_asystent;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Raportowanie extends AppCompatActivity {

    Boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raportowanie);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Main.class);
        startActivityForResult(myIntent, 0);
        return true;

    }

    public void onClick_reportStatus(View v){
        ChangeStatus();

        TextView tv = findViewById(R.id.textRaportStatus);

        if(tv.getText().toString().equals("AKTYWNA")){
            tv.setTextColor(Color.parseColor("#e60000"));
            tv.setText("NIEKATYWNA");
        }else if (tv.getText().toString().equals("NIEKATYWNA")){
            tv.setTextColor(Color.parseColor("#99e600"));
            tv.setText("AKTYWNA");

        }
    }

    public void onClick_reportConf(View v){
        startActivity(new Intent(this, RaportowanieKonf.class));
    }

    public void ChangeStatus(){
        TimerTask ttOkay = new TimerTask() {
            @Override
            public void run() {
                // Wywołać okno z pytaniem
            }
        };

        TimerTask ttEnd = new TimerTask() {
            @Override
            public void run() {
                cancel();
            }
        };

        if(status==false) {
            Toast.makeText(getApplicationContext(), "Raportowanie aktywne przez 4h", Toast.LENGTH_LONG).show();
            status = true;
            Timer t = new Timer();
            t.scheduleAtFixedRate(ttOkay, new Date(),15*60*1000);
            t.schedule(ttEnd,4*60*60*1000);
        }
        if(status==true){
            Toast.makeText(getApplicationContext(), "Raportowanie wyłączone", Toast.LENGTH_SHORT).show();
            status = false;
        }

    }


}
