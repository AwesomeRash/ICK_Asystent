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

public class PrzepisListAdapter extends ArrayAdapter {

    private final Activity context;
    private final Integer[] imageIDarray;
    private final String[] nameArray;
    private final String[] trudArray;
    private final String[] czasArray;
    
    public PrzepisListAdapter(Activity context, String[] nameArrayParam, String[] trudArrayParam, String[] czasArrayParam, Integer[] imageIDArrayParam){

        super(context,R.layout.listview_row , nameArrayParam);

        this.context=context;
        this.imageIDarray = imageIDArrayParam;
        this.nameArray = nameArrayParam;
        this.trudArray = trudArrayParam;
        this.czasArray = czasArrayParam;

    }

    public PrzepisListAdapter(Activity context, ArrayList<PrzepisDBModel> przepisy, String[] nameArray){
        super(context, R.layout.listview_row, nameArray);

        this.context=context;
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> trud = new ArrayList<>();
        ArrayList<String> czas = new ArrayList<>();

        ArrayList<Integer> img = new ArrayList<>();

        for(PrzepisDBModel przep: przepisy){
            name.add(przep.nazwa);
            trud.add(przep.trudnosc);
            czas.add(przep.czas);
            img.add(przep.id);
        }
        this.nameArray = name.toArray(new String[name.size()]);
        this.trudArray = trud.toArray(new String[trud.size()]);
        this.czasArray = czas.toArray(new String[czas.size()]);
        this.imageIDarray = img.toArray(new Integer[img.size()]);
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.przepis_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.przepis_nazwa);
        TextView infoTextField = (TextView) rowView.findViewById(R.id.przepis_trudność);
        TextView czasTextField = (TextView) rowView.findViewById(R.id.przepis_czas);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.przepis_ilustracja);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray[position]);
        infoTextField.setText(trudArray[position]);
        czasTextField.setText(czasArray[position]);
        imageView.setImageResource(imageIDarray[position]);

        return rowView;

    };


}
