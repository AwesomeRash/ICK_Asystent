package com.ick.ick_asystent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PrzepisView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przepis_view);
    }

    @Override
    protected void onStart(){
        super.onStart();

        Bundle b = getIntent().getExtras();
        String nazwa = "";

        if (b!=null){
            nazwa = b.getString("przepis_name");
        }

        DBHelper myDB = new DBHelper(getApplicationContext());
        PrzepisDBModel przepisMdl = myDB.getPrzepisName(nazwa);
        myDB.close();


        TextView skladniki = findViewById(R.id.skladText);
        TextView przepis = findViewById(R.id.przepText);
        ImageView img = findViewById(R.id.przepImg);


        skladniki.setText(przepisMdl.składniki);
        przepis.setText(przepisMdl.przepis);
        img.setImageResource(przepisMdl.obraz);

    }
}
