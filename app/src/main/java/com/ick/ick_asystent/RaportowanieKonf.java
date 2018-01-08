package com.ick.ick_asystent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RaportowanieKonf extends AppCompatActivity {

    EditText phone;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raportowanie_konf);
        phone = findViewById(R.id.nrTel);
        myDB = new DBHelper(getApplicationContext());

        if (myDB.getSetting("telefon") != null) phone.setText(myDB.getSetting("telefon"));
        else phone.setText("");
    }

    public void onClick_confirm (View view) {
        if (myDB.getSetting("telefon") != null) myDB.createSetting("telefon", phone.getText().toString());
        else myDB.updateSetting(0, "telefon", phone.getText().toString());
    }

    public void onClick_test(View view) {
        sendSMS(myDB.getSetting("telefon"), "Test wiadomości alarmowej");
    }

    private void sendSMS(String phoneNumber, String message) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS Sent!",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "SMS failed, please try again later!",
                    Toast.LENGTH_LONG).show();

        }
    }
}
