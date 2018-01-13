package com.ick.ick_asystent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

//TODO: Szacowanie na podstawie terminów kolejnych rachunków.
//Zmiana automatycznie przy wybraniu opcji na dropdownie
//Każdy rachunek i suma w osobnej linijce
// Główna suma osobno.

public class SzacowanieWydatkow extends AppCompatActivity {

    DBHelper myDB;
    ListView listView;
    float suma[] = {0, 0, 0, 0, 0};
    double billSum=0.0;
    TextView srednia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szacowanie_wydatkow);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myDB = new DBHelper(getApplicationContext());

        ArrayList<RachunekDBModel> rachunki = myDB.getAllRachunek();
        srednia = findViewById(R.id.textKwotaSzac);
        listView = findViewById(R.id.rachunkiListView);
        final Spinner spinner = findViewById(R.id.szacowanieSpinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                System.out.println(spinner.getSelectedItemPosition()+ "    -    " + spinner.getSelectedItem().toString());
                countBills();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });

        countBills();

    }


    public void countBills(){
        billSum = 0.0;

        myDB = new DBHelper(getApplicationContext());
        Calendar paymentCal = Calendar.getInstance();
        ArrayList<RachunekDBModel> displayArrayList = new ArrayList<RachunekDBModel>();
        Spinner spinnerSzacowania = findViewById(R.id.szacowanieSpinner);
        int okresSzacowania = spinnerSzacowania.getSelectedItemPosition();

        if(okresSzacowania == 0){
            paymentCal.add(Calendar.MONTH, 1);
        }else if(okresSzacowania == 1){
            paymentCal.add(Calendar.MONTH, 2);
        }else if (okresSzacowania == 2){
            paymentCal.add(Calendar.MONTH, 3);
        }else if (okresSzacowania == 3){
            paymentCal.add(Calendar.MONTH, 6);
        } else if (okresSzacowania == 4){
            paymentCal.add(Calendar.MONTH, 12);
        }


        ArrayList<RachunekDBModel> rachunki = myDB.getAllRachunek();

        for(RachunekDBModel mdl : rachunki) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Double avg = (mdl.rachunek1+mdl.rachunek2+mdl.rachunek3)/3.0;
            try{
                Date data = formatter.parse(mdl.ostatnioOplacony);
                Calendar cal = Calendar.getInstance();
                cal.setTime(data);

                if(cal.before(paymentCal)){
                    int monthsBetween = paymentCal.get(Calendar.MONTH) - cal.get(Calendar.MONTH) + 12*(paymentCal.get(Calendar.YEAR)-cal.get(Calendar.YEAR));


                    if(mdl.jakCzesto == 0){
                        Double wysokosc = monthsBetween*avg;

                        System.out.println("Months Between: "+monthsBetween  + "AVG: "+avg);
                        if(monthsBetween!= 0){
                            billSum += wysokosc;
                            displayArrayList.add(mdl);
                        }

                    }else if(mdl.jakCzesto == 1){
                        Integer okresy = (monthsBetween/2);
                                Double wysokosc = okresy*avg;


                        if(okresy != 0){
                            billSum += wysokosc;
                            displayArrayList.add(mdl);
                        }

                    }else if (mdl.jakCzesto == 2){
                        Integer okresy = (monthsBetween/3);
                        Double wysokosc = okresy*avg;

                        if(okresy != 0){
                            billSum += wysokosc;
                            displayArrayList.add(mdl);
                        }

                    }else if (mdl.jakCzesto == 3){
                        Integer okresy = (monthsBetween/6);
                        Double wysokosc = okresy*avg;

                        if(okresy != 0){
                            billSum += wysokosc;
                            displayArrayList.add(mdl);
                        }
                    }
                }

            } catch (ParseException e){
                e.printStackTrace();
            }

        }

        String[] nameArray = new String[displayArrayList.size()];
        RachunekListAdapter rachAdp = new RachunekListAdapter(this, displayArrayList, nameArray);
        listView.setAdapter(rachAdp);

        DecimalFormat df = new DecimalFormat("#.00");

        srednia.setText(df.format(billSum)+" zł");
        myDB.close();
    }
}
