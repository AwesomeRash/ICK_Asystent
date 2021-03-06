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

public class LekListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the animal images
    private final Integer[] imageIDarray;

    //to store the list of countries
    private final String[] nameArray;

    //to store the list of countries
    private final String[] infoArray;

    public LekListAdapter(Activity context, ArrayList<LekDBModel> leki, String[] nameArray){
        super(context,R.layout.lek_row, nameArray);

        this.context=context;
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> info = new ArrayList<>();
        ArrayList<Integer> img = new ArrayList<>();

        for (LekDBModel lek: leki) {

            name.add(lek.nazwa);
            info.add(lek.kiedy);

            if(lek.rodzaj == 0){
                img.add(R.drawable.ic_action_name);
            } else if (lek.rodzaj==1){
                img.add(R.drawable.syrop);
            }else if(lek.rodzaj==2){
                img.add(R.drawable.zastrzyk);
            }

        }
        this.nameArray = name.toArray(new String[name.size()]);
        this.infoArray = info.toArray(new String[info.size()]);
        this.imageIDarray = img.toArray(new Integer[img.size()]);
    }

    public LekListAdapter(Activity context, String[] nameArrayParam, String[] infoArrayParam, Integer[] imageIDArrayParam){

        super(context,R.layout.lek_row , nameArrayParam);

        this.context=context;
        this.imageIDarray = imageIDArrayParam;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.lek_row, null,true);


        TextView nameTextField = (TextView) rowView.findViewById(R.id.nameTextViewID);
        TextView infoTextField = (TextView) rowView.findViewById(R.id.infoTextViewID);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView1ID);


        nameTextField.setText(nameArray[position]);
        infoTextField.setText(infoArray[position]);
        imageView.setImageResource(imageIDarray[position]);

        return rowView;

    };


}
