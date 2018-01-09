package com.ick.ick_asystent;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

public class ReportingPopup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporting_popup);
    }

    protected void onStart(){
        super.onStart();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sendHelpRequest();
            }
        }, 30*1000);
    }

    protected void onClick_confirm(View view){
        this.finish();
    }

    public void sendHelpRequest(){

        SharedPreferences sp = this.getSharedPreferences("com.ick.ick_asystent", Context.MODE_PRIVATE);
        String numer = sp.getString("telefon", "");
        String user = sp.getString("user", "Uzytkownik Aplikacji");

        if(!numer.equals("")){
            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(numer, null, user+" nie reaguje na zapytania. Skontaktuj się z nim.", null, null);

                Toast.makeText(getApplicationContext(), "SMS Wyslany.",
                        Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),
                        "Wysylanie nie powiodlo sie.",
                        Toast.LENGTH_LONG).show();

            }
        }
    }
}
