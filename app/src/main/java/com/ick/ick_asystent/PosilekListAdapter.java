package com.ick.ick_asystent;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Roderick on 27.11.2017.
 */

public class PosilekListAdapter extends ArrayAdapter {

    private final Activity context;
    private final Integer[] imageIDarray;
    private final String[] nameArray;
    private final String[] infoArray;

    public PosilekListAdapter(Activity context, ArrayList<PosilekDBModel> posilki, String[] nameArray){
        super(context,R.layout.listview_row, nameArray);

        System.out.println("LICZBA POSILKOW: " + posilki.size());
        this.context=context;
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> info = new ArrayList<>();
        ArrayList<Integer> img = new ArrayList<>();

        for (PosilekDBModel pos: posilki) {

            name.add(pos.nazwa);
            info.add(pos.godzina);

            if(pos.typ == 0){
                img.add(R.drawable.sniadanie);
            } else if (pos.typ==1) {
                img.add(R.drawable.ic_45471);
            }
        }
        this.nameArray = name.toArray(new String[name.size()]);
        this.infoArray = info.toArray(new String[info.size()]);
        this.imageIDarray = img.toArray(new Integer[img.size()]);
    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);


        TextView nameTextField = (TextView) rowView.findViewById(R.id.nameTextViewID);
        TextView infoTextField = (TextView) rowView.findViewById(R.id.infoTextViewID);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView1ID);


        nameTextField.setText(nameArray[position]);
        infoTextField.setText(infoArray[position]);
        imageView.setImageResource(imageIDarray[position]);

        return rowView;

    }


    public String getItem (int position){
        return nameArray[position];
    }


}
