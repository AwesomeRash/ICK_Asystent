package com.ick.ick_asystent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ModPosilek extends AppCompatActivity {

    Integer posilekID = 0;
    TextView name;
    Spinner spn;
    EditText termin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_posilek);
    }

    protected  void onStart(){
        super.onStart();

        Bundle b = getIntent().getExtras();
        String nazwa = "";
        if (b!=null){
            nazwa = b.getString("posilek");
        }
        DBHelper myDB = new DBHelper(getApplicationContext());
        PosilekDBModel posilek = myDB.getPosilekName(nazwa);
        myDB.close();

        posilekID = posilek.id;

        name = findViewById(R.id.modPosilekText);
        spn = findViewById(R.id.posilekModSpinner);
        termin = findViewById(R.id.terminPosilkuMod);

        name.setText(nazwa);
        spn.setSelection(posilek.typ);
        termin.setText(posilek.godzina);
    }

    public void onClick_RemovePosilek(View view){
        DBHelper myDB = new DBHelper(getApplicationContext());
        myDB.deletePosilek(posilekID);
        myDB.close();
        startActivity(new Intent(this, Jedzenie.class));
    }

    public void onClick_confirmPosilekChanges(View view){
        DBHelper myDB = new DBHelper(getApplicationContext());
        myDB.updatePosilek(posilekID, name.getText().toString(), spn.getSelectedItemPosition(), termin.getText().toString());
        myDB.close();
        startActivity(new Intent(this, Jedzenie.class));
    }
}
