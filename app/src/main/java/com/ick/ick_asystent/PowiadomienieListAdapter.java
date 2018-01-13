package com.ick.ick_asystent;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Roderick on 13.01.2018.
 */

public class PowiadomienieListAdapter extends ArrayAdapter {

    private final Activity context;
    private final String[] nameArray;
    private final String[] terminArray;
    private final Integer[] powtarzalneArray;
    private final Integer[] aktywneArray;

    public PowiadomienieListAdapter(Activity context, ArrayList<PowiadomienieDBModel> powiadomienia, String[] nameArrayParam){
        super(context,R.layout.listview_row, nameArrayParam);

        this.context = context;
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> termin = new ArrayList<>();
        ArrayList<Integer> powtarzalne = new ArrayList<>();
        ArrayList<Integer> aktywne = new ArrayList<>();

        if(powiadomienia.size()!=0){
            for (PowiadomienieDBModel mdl : powiadomienia){
                name.add(mdl.nazwa);
                termin.add(mdl.kiedy);

                if(mdl.powtarzalne){
                    powtarzalne.add(1);
                } else{
                    powtarzalne.add(0);
                }

                if(mdl.aktywne){
                    aktywne.add(1);
                } else{
                    aktywne.add(0);
                }

                System.out.println(mdl.nazwa+"  -  "+mdl.kiedy);
            }

            nameArray = name.toArray(new String[name.size()]);
            terminArray = termin.toArray(new String[termin.size()]);
            aktywneArray = aktywne.toArray(new Integer[aktywne.size()]);
            powtarzalneArray = powtarzalne.toArray(new Integer[powtarzalne.size()]);
        } else{
            nameArray = new String[]{};
            terminArray = new String[]{};
            aktywneArray = new Integer[]{};
            powtarzalneArray = new Integer[]{};
        }

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.powiadomienie_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nazwaText = (TextView) rowView.findViewById(R.id.powNazwa);
        TextView terminText = (TextView) rowView.findViewById(R.id.powTermin);
        TextView aktywneText = (TextView) rowView.findViewById(R.id.powAktywne);
        TextView powtarzalneText = (TextView) rowView.findViewById(R.id.powPowtarzalne);

        //this code sets the values of the objects to values from the arrays
        nazwaText.setText(nameArray[position]);
        terminText.setText(terminArray[position]);
        if(aktywneArray[position]==1){
            aktywneText.setText("Aktywny");
        } else{
            aktywneText.setText("Nieaktywny");
        }

        if(powtarzalneArray[position]==1){
            powtarzalneText. setText("Powtarzany");
        }else{
            powtarzalneText. setText("Jednorazowy");
        }
        return rowView;
    }

}
