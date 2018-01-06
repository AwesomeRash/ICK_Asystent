package com.ick.ick_asystent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Przepisy extends AppCompatActivity {


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przepisy);
    }

    @Override
    protected void onStart(){
        super.onStart();
        DBHelper myDB = new DBHelper(getApplicationContext());

        ArrayList<PrzepisDBModel> przepisy = myDB.getAllPrzepis();
        String[] nameArray = new String[przepisy.size()];

        PrzepisListAdapter przeAdp = new PrzepisListAdapter(this, przepisy,nameArray);
        listView = findViewById(R.id.przepisyList);
        listView.setAdapter(przeAdp);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();

                Bundle b = new Bundle();
                b.putString("przepis_name", item);
                System.out.println(item + " Putting to bundle");
                Intent intent = new Intent(view.getContext(), PrzepisView.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        myDB.close();

    }

}
