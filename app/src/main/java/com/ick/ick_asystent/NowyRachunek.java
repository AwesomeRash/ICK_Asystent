package com.ick.ick_asystent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

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

        Pattern p = Pattern.compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");

        if(p.matcher(text2.getText().toString()).matches()){
        myDB.createRachunek(text1.getText().toString(),
                            text2.getText().toString(),
                            spinner.getSelectedItemPosition(),
                            Integer.parseInt(text4.getText().toString()),
                            Integer.parseInt(text5.getText().toString()),
                            Integer.parseInt(text6.getText().toString())

        );

        startActivity(new Intent(this, Rachunki.class));
    }else{
            Toast.makeText(getApplicationContext(), "Niepoprawny format daty", Toast.LENGTH_SHORT).show();
        }
    }
}
