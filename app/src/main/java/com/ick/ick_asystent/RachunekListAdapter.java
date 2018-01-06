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

public class RachunekListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the animal images
    private final String[] dateArray;

    //to store the list of countries
    private final String[] nameArray;

    //to store the list of countries
    private final String[] infoArray;

    public RachunekListAdapter(Activity context, String[] nameArrayParam, String[] infoArrayParam, String[] dateArrayParam){

        super(context,R.layout.listview_row , nameArrayParam);

        this.context=context;
        this.dateArray = dateArrayParam;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;

    }

    public RachunekListAdapter(Activity context, ArrayList<RachunekDBModel> rachunki, String[] nameArrayParam){
        super(context,R.layout.listview_row, nameArrayParam);

        this.context=context;
        ArrayList<String> date = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> info = new ArrayList<>();

        if(rachunki.size()!=0) {
            for (RachunekDBModel mdl : rachunki) {
                int rachSum = mdl.rachunek1 + mdl.rachunek2 + mdl.rachunek3;

                date.add(mdl.ostatnioOplacony); // ToDo: Do zmiany na poprawną datę w zależności od wybranego typu.
                name.add(mdl.nazwa);
                info.add(Double.toString(rachSum / 3));
            }

            this.dateArray = date.toArray(new String[date.size()]);
            this.nameArray = name.toArray(new String[name.size()]);
            this.infoArray = info.toArray(new String[info.size()]);
        } else{
            dateArray = new String[]{};
            nameArray = new String[]{};
            infoArray = new String[]{};
        }

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.rachunek_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.rachunek_name);
        TextView infoTextField = (TextView) rowView.findViewById(R.id.rachunek_info);
        TextView dateTextField = (TextView) rowView.findViewById(R.id.rachunek_date);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray[position]);
        infoTextField.setText(infoArray[position]);
        dateTextField.setText(dateArray[position]);

        return rowView;

    };


}
