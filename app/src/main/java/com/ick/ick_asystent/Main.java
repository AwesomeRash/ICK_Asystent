package com.ick.ick_asystent;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TYLKO DO TESTOWANIA/USUWANIA RZECZY.
        DBHelper myDB = new DBHelper(getApplicationContext());
        myDB.resetDB();
        myDB.close();

      prepareDB();
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

    public void onClick_Emergency(View view){
        startActivity(new Intent(this, Emergency.class ));
    }

    public void prepareDB(){
        DBHelper myDB = new DBHelper(getApplicationContext());
        myDB.createPrzepis("Przepis1", "Latwy", "15 min", "2 filety z kurczaka, Brokuł, śmietana kremówka, serek topiony gouda", "Wrzuć rzeczy razem, a potem je wymieszaj, lol", R.drawable.ic_launcher_foreground);
        myDB.createPrzepis("Przepis2", "Trudny","45 min", "3 plastry schabu, sos z torebki", "Nie wiem, wymyśl sobie coś.",R.drawable.ic_launcher_foreground);
        myDB.createPrzepis("Przepis3","Trudny", "90 min", "Klawiatura, monitor, myszka, mięso, pieniądze, narkotyki", "W zasadzie to to nie jest przepis, ale potrzebuję tekstu żeby wypełnić DB.",R.drawable.ic_launcher_foreground);

        myDB.createPosilek("Sniadanie", 0, "11:00");
        myDB.createPosilek("Obiad", 1, "17:00");

    }

}
