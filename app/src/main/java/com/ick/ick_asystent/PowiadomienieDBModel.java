package com.ick.ick_asystent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Roderick on 13.01.2018.
 */

public class PowiadomienieDBModel {
    Integer id;
    String nazwa;
    String kiedy;
    Boolean powtarzalne;
    Boolean aktywne;

    public PowiadomienieDBModel(Integer id, String nazwa, String kiedy, Integer powtarzalne, Integer aktywne){

        Boolean powt=true;
        Boolean akt=true;

        if(powtarzalne != 0){
            powt = true;
        } else{
            powt = false;
        }

        if(aktywne != 0){
            akt = true;
        } else {
            akt = false;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");


        this.id = id;
        this.nazwa = nazwa;
        this.powtarzalne = powt;
        this.aktywne= akt;
        this.kiedy = kiedy;
/*        try{

            this.kiedy = formatter.parse(kiedy);
        }
        catch(ParseException e){

        }
        */
    }

}
