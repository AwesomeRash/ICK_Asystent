package com.ick.ick_asystent;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Roderick on 27.11.2017.
 */

public class ZamiennikiListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the animal images
    private final String[] cenaArray;

    //to store the list of countries
    private final String[] nameArray;

    //to store the list of countries
    private final String[] iloscArray;

    public ZamiennikiListAdapter(Activity context, String[] nameArrayParam, String[] iloscArrayParam, String[] cenaArrayParam){

        super(context,R.layout.listview_row , nameArrayParam);

        this.context=context;
        this.cenaArray = cenaArrayParam;
        this.nameArray = nameArrayParam;
        this.iloscArray = iloscArrayParam;

    }

    public ZamiennikiListAdapter(Activity context, ArrayList<LekarstwoDBModel> lekarstwa, String[] nameArrayParam){
        super(context, R.layout.listview_row, nameArrayParam);

        this.context = context;

        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> opakowanie = new ArrayList<>();
        ArrayList<String> cena = new ArrayList<>();

        if(lekarstwa.size()!=0){
            for(LekarstwoDBModel mdl: lekarstwa){
                name.add(mdl.nazwa);
                opakowanie.add(mdl.opakowanie);
                cena.add(Double.toString(mdl.cena)+" zł");
            }

            this.nameArray = name.toArray(new String[name.size()]);
            this.iloscArray = opakowanie.toArray(new String[opakowanie.size()]);
            this.cenaArray = cena.toArray(new String[cena.size()]);
        }
        else{
            nameArray = new String[]{};
            iloscArray = new String []{};
            cenaArray = new String []{};
        }
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.zamiennik_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.lek_nazwa);
        TextView infoTextField = (TextView) rowView.findViewById(R.id.lek_ilosc);
        TextView cenaTextField = (TextView) rowView.findViewById(R.id.lek_cena);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray[position]);
        infoTextField.setText(iloscArray[position]);
        cenaTextField.setText(cenaArray[position]);

        return rowView;

    };


}
