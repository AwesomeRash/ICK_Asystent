package com.ick.ick_asystent;

/**
 * Created by Roderick on 05.01.2018.
 */

public class LekDBModel {
    Integer id;
    String nazwa;
    Integer rodzaj;
    String koniecPrzyjmowania;
    String kiedy;

    public  LekDBModel(){

    }

    public  LekDBModel(int id, String name, int type, String end, String when){
        this.id = id;
        nazwa = name;
        rodzaj = type;
        kiedy = when;
        koniecPrzyjmowania = end;
    }
}
